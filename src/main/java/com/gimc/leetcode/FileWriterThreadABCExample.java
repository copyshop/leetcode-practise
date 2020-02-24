package com.gimc.leetcode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yin.he
 * @date: 2020/2/9
 * @desc:
 */
public class FileWriterThreadABCExample {
    public static void main(String[] args) {
        FileWriteUtil util = new FileWriteUtil();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new WriteRunnable(util, 1, 'A'));
        service.execute(new WriteRunnable(util, 2, 'B'));
        service.execute(new WriteRunnable(util, 3, 'C'));
        service.execute(new WriteRunnable(util, 4, 'D'));
        service.shutdown();
    }
}


class FileWriteUtil {

    private int currentThreadNum = 1;
    /**
     * 记录将字符写入文件的次数
     */
    private int count = 0;
    private int currentFileNum = 1;

    public void write(char value, int threadNum) {
        generateNextFileNum();
        FileWriter writer = null;
        try {
            writer = new FileWriter("file" + currentFileNum + ".txt", true);
            writer.write(String.valueOf(value));
            System.out.printf("ThreadNum=%d is executing. %c is written into file file%d.txt \n",
                    currentThreadNum, value, currentFileNum);
            writer.flush();
            count++;
            currentThreadNum = threadNum;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (null != writer) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                writer = null;
            }
        }
        generateNextThreadNum();
    }

    public int getCurrentThreadNum() { return currentThreadNum; }

    public void setCurrentThreadNum(int currentThreadNum) { this.currentThreadNum = currentThreadNum; }

    private void generateNextFileNum() {
        if (count % 4 == 0) {
            currentFileNum = 1;
        } else {
            currentFileNum++;
        }
    }

    private void generateNextThreadNum() {
        if (count % 4 == 0) {
            if (currentThreadNum < 3) {
                currentThreadNum += 2;
            } else {
                currentThreadNum = (currentThreadNum + 2) % 4;
            }
        } else {
            if (currentThreadNum == 4) {
                currentThreadNum = 1;
            } else {
                currentThreadNum++;
            }
        }
    }
}

class WriteRunnable implements Runnable {

    private FileWriteUtil util = null;

    private int threadNum = 1;

    private char value = ' ';

    /**
     * @param util
     */
    public WriteRunnable(FileWriteUtil util, int threadNum, char value) {
        super();
        this.util = util;
        this.threadNum = threadNum;
        this.value = value;
    }

    @Override
    public void run() {
        /**
         * 假设循环16次， 一直循环可以使用while(true) 或者 for(;;)
         */
        for (int i = 0; i < 16; i++) {
            synchronized (util) {
                while (threadNum != util.getCurrentThreadNum()) {
                    try {
                        util.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                util.write(value, threadNum);
                util.notifyAll();
            }
        }
    }
}


package com.gimc.leetcode;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yin.he
 * @date: 2020/2/9
 * @desc:
 */
public class PrintThreadABC10Example {

    public static void main(String[] args) {
        PrintThreadABC10Example example = new PrintThreadABC10Example();
        LetterPrinter letterPrinter = example.new LetterPrinter();
        ExecutorService service = Executors.newFixedThreadPool(3,
                new ThreadFactoryBuilder().setNameFormat("print-thread-").build());
        service.execute(example.new PrintRunnable(letterPrinter, 'A'));
        service.execute(example.new PrintRunnable(letterPrinter, 'B'));
        service.execute(example.new PrintRunnable(letterPrinter, 'C'));
        service.shutdown();
    }

    private class LetterPrinter {
        private char letter = 'A';

        public void print() {
            System.out.println(letter);
            if ('C' == letter) {
                System.out.println();
            }
        }

        public void nextLetter() {
            switch (letter) {
                case 'A':
                    letter = 'B';
                    break;
                case 'B':
                    letter = 'C';
                    break;
                case 'C':
                    letter = 'A';
                    break;
            }
        }

        /**
         * @return the letter
         */
        public char getLetter() {
            return letter;
        }

    }

    private class PrintRunnable implements Runnable {

        private LetterPrinter letterPrinter = null;

        private char letter = ' ';

        /**
         * @param letterPrinter
         * @param letter
         */
        public PrintRunnable(LetterPrinter letterPrinter, char letter) {
            super();
            this.letterPrinter = letterPrinter;
            this.letter = letter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (letterPrinter) {
                    while (letter != letterPrinter.getLetter()) {
                        try {
                            letterPrinter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    letterPrinter.print();
                    letterPrinter.nextLetter();
                    letterPrinter.notifyAll();

                }
            }
        }
    }
}
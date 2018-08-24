package com.gimc.leetcode;

/**
 * author: heyin
 * date: 2018-08-24
 * desc: 矩阵旋转
 */
public class ArrayRotate {

    public static void main(String args[]) {
        int data[][] = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        handleTwo(data);
        print(data);
    }

    //将矩阵转置
    public static void reverse(int temp[][]) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = i; j < temp[i].length; j++) {
                int k = temp[i][j];
                temp[i][j] = temp[j][i];
                temp[j][i] = k;
            }
        }
    }

    //将转置后的矩阵的列交换（第一列跟最后一列交换，第二列跟倒数第二列交换）
    public static void exchange(int temp[][]) {
        int a = 0;
        int b = temp.length - 1;
        for (int i = 0; i < (temp.length) / 2; i++) {
            for (int j = 0; j < temp.length; j++) {
                int k = temp[j][a];
                temp[j][a] = temp[j][b];
                temp[j][b] = k;
            }
            a++;
            b--;
        }
    }

    //将矩阵输出
    public static void print(int temp[][]) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.print(temp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 首先将矩阵转置，然后翻转即可
     *
     * @param data 输入参数
     */
    public static void handleOne(int[][] data) {
        reverse(data);
        exchange(data);
    }

    public static void handleTwo(int[][] data) {
        int len = data.length;
        int temp[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[j][len - 1 - i] = data[i][j];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                data[i][j] = temp[i][j];
            }
        }
    }
}



package com.gimc.leetcode;

import java.util.Scanner;

class GraphMatrix {
    static final int maxNum = 20;
    static final int maxValue = 65535;
    char[] vertex = new char[maxNum];
    int GType;
    int vertexNum;
    int edgeNum;
    int[][] edgeWeight = new int[maxNum][maxNum];
    int[] isTrav = new int[maxNum];
}

public class GraphMatrixBasic {
    static Scanner input = new Scanner(System.in);

    static void CreateGraph(GraphMatrix GM) {
        int i, j, k;
        int weight;
        char EstartV, EendV;

        System.out.printf("??????и????????\n");
        for (i = 0; i < GM.vertexNum; i++) {
            System.out.printf("??%d??????:", i + 1);
            GM.vertex[i] = (input.next().toCharArray())[0];
        }
        System.out.printf("???????????????:\n");
        for (k = 0; k < GM.edgeNum; k++) {
            System.out.printf("??%d?????", k + 1);
            EstartV = input.next().charAt(0);
            EendV = input.next().charAt(0);
            weight = input.nextInt();
            for (i = 0; EstartV != GM.vertex[i]; i++) {
                for (j = 0; EendV != GM.vertex[j]; j++) {
                    GM.edgeWeight[i][j] = weight;
                    if (GM.GType == 0) {
                        GM.edgeWeight[j][i] = weight;
                    }
                }
            }
        }
    }

    static void ClearGraph(GraphMatrix GM) {
        int i, j;

        for (i = 0; i < GM.vertexNum; i++) {
            for (j = 0; j < GM.vertexNum; j++) {
                GM.edgeWeight[i][j] = GraphMatrix.maxValue;
            }
        }
    }

    static void OutGraph(GraphMatrix GM) {
        int i, j;
        for (j = 0; j < GM.vertexNum; j++) {
            System.out.printf("\t%c", GM.vertex[j]);
        }
        System.out.printf("\n");
        for (i = 0; i < GM.vertexNum; i++) {
            System.out.printf("%c", GM.vertex[i]);
            for (j = 0; j < GM.vertexNum; j++) {
                if (GM.edgeWeight[i][j] == GraphMatrix.maxValue) {
                    System.out.printf("\tZ");
                } else {
                    System.out.printf("\t%d", GM.edgeWeight[i][j]);
                }
            }
            System.out.printf("\n");
        }
    }

    static void DeepTraOne(GraphMatrix GM, int n) {
        int i;
        GM.isTrav[n] = 1;
        System.out.printf("->%c", GM.vertex[n]);

        for (i = 0; i < GM.vertexNum; i++) {
            if (GM.edgeWeight[n][i] != GraphMatrix.maxValue && GM.isTrav[n] == 0) {
                DeepTraOne(GM, i);
            }
        }
    }

    static void DeepTraGraph(GraphMatrix GM) {
        int i;
        for (i = 0; i < GM.vertexNum; i++) {
            GM.isTrav[i] = 0;
        }
        System.out.printf("?????????????:");
        for (i = 0; i < GM.vertexNum; i++) {
            if (GM.isTrav[i] == 0) {
                DeepTraOne(GM, i);
            }
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        GraphMatrix GM = new GraphMatrix();

        System.out.printf("???????????????:");
        GM.GType = input.nextInt();
        System.out.printf("??????????????:");
        GM.vertexNum = input.nextInt();
        System.out.printf("????????????:");
        GM.edgeNum = input.nextInt();
        ClearGraph(GM);
        CreateGraph(GM);
        System.out.printf("???????????????????:\n");
        OutGraph(GM);
        DeepTraGraph(GM);
    }
}

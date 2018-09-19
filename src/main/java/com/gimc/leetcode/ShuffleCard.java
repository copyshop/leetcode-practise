package com.gimc.leetcode;

import java.util.Random;

/**
 * author: heyin
 * date: 2018-09-19
 * desc: 洗扑克排程序
 */
class Card {
    int suit;                            //花色
    char number;                         //牌数
}

public class ShuffleCard {

    //保存每张扑克的花色、数字
    static Card[] oneCard = new Card[52];

    //显示扑克牌
    static void showCard() {
        int i, j;
        String s = "";

        for (i = 0, j = 0; i < 52; i++, j++) {
            if (j % 13 == 0) {
                System.out.print("\n");
            }
            //显示花色符号
            switch (oneCard[i].suit) {
                case 1:
                    s = "黑桃";
                    break;
                case 2:
                    s = "红桃";
                    break;
                case 3:
                    s = "梅花";
                    break;
                case 4:
                    s = "方块";
                    break;
                default:
                    break;
            }
            System.out.printf("  " + s + oneCard[i].number);    //输出显示
        }
        System.out.print("\n");
    }

    //算法
    static void shuffle() {
        int i, j, temp;
        int suit;

        Card tempcard = new Card();

        suit = 0;
        for (i = 0; i < 52; i++) {
            if (i % 13 == 0) {
                suit++;
            }
            Card t = new Card();
            t.suit = suit;
            temp = i % 13;
            switch (temp) {
                case 0:
                    t.number = 'A';
                    break;
                case 9:
                    t.number = '0';
                    break;
                case 10:
                    t.number = 'J';
                    break;
                case 11:
                    t.number = 'Q';
                    break;
                case 12:
                    t.number = 'K';
                    break;
                default:
                    t.number = (char) (temp + '1');
            }
            oneCard[i] = t;
        }
        System.out.printf("一付新牌的初始排列如下:\n");

        showCard();

        Random r = new Random();                    //随机种子
        for (i = 0; i < 52; i++) {
            j = r.nextInt(52);              //随机换牌
            tempcard = oneCard[j];
            oneCard[j] = oneCard[i];
            oneCard[i] = tempcard;
        }
    }

    public static void main(String[] args) {
        shuffle();                                //洗牌
        System.out.print("\n洗牌后的排列如下:\n");
        showCard();                               //显示新牌的排列
    }
}
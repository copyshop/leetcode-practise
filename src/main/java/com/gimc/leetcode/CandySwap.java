package com.gimc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * author: heyin
 * date: 2018-09-20
 * desc:  公平的糖果交换(https://leetcode-cn.com/articles/fair-candy-swap/)
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 */
public class CandySwap {

    public static void main(String[] args) {
        int[] a = {1, 1};
        int[] b = {2, 2};
        int[] result = fairCandySwap(a, b);
        System.out.println(result);
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        // sum of A, B respectively
        int sa = 0, sb = 0;
        for (int x : A) {
            sa += x;
        }
        for (int x : B) {
            sb += x;
        }
        int delta = (sb - sa) / 2;
        // If Alice gives x, she expects to receive x + delta
        Set<Integer> setB = new HashSet();
        for (int x : B) {
            setB.add(x);
        }
        for (int x : A) {
            if (setB.contains(x + delta)) {
                return new int[] {x, x + delta};
            }
        }
        throw null;
    }
}

package com.gimc.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 画家
 * @date 2019-05-18
 * @desc https://leetcode-cn.com/articles/maximum-width-ramp/
 */
public class MaxWidthRamp {

    public static void main(String[] args) {
        int[] a = {6, 0, 8, 2, 1, 5};
        int result = new MaxWidthRamp().maxWidthRamp(a);
        System.out.println(result);
    }

    private int maxWidthRamp(int[] a) {
        int n = a.length;
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; ++i) {
            b[i] = i;
        }
        Arrays.sort(b, Comparator.comparingInt(i -> a[i]));
        int max = 0;
        int min = n;
        for (int i : b) {
            max = Math.max(max, i - min);
            min = Math.min(min, i);
        }
        return max;
    }
}

package com.gimc.leetcode;

import java.util.HashMap;

/**
 * @author: yin.he
 * @date: 2019-09-17
 * @desc:
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(isPossiblePart(nums));
    }


    /**
     * 使用贪心算法
     *
     * @param nums
     * @return
     */
    private static boolean isPossiblePart(int[] nums) {
        Counter count = new Counter();
        Counter tails = new Counter();
        for (int x : nums) {
            count.add(x, 1);
        }
        for (int x : nums) {
            if (count.get(x) == 0) {
                continue;
            } else if (tails.get(x) > 0) {
                tails.add(x, -1);
                tails.add(x + 1, 1);
            } else if (count.get(x + 1) > 0 && count.get(x + 2) > 0) {
                count.add(x + 1, -1);
                count.add(x + 2, -1);
                tails.add(x + 3, 1);
            } else {
                return false;
            }
            count.add(x, -1);
        }
        return true;
    }
}


class Counter extends HashMap<Integer, Integer> {
    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
    }
    public void add(int k, int v) {
        put(k, get(k) + v);
    }
}


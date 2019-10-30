package com.gimc.leetcode;

/**
 * author: heyin
 * date: 2019-05-23
 * desc:
 */
public class ClimbStairs {
    
    public static void main(String[] args) {
        new ClimbStairs().climbStairs(7);
    }
    
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

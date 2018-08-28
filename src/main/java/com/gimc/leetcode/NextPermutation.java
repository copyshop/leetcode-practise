package com.gimc.leetcode;

/**
 * author: heyin
 * date: 2018-08-24
 * desc:
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 复杂度分析
 * 时间复杂度：O(n)O(n)，在最坏的情况下，只需要对整个数组进行两次扫描。
 * 空间复杂度：O(1)O(1)，没有使用额外的空间，原地替换足以做到。
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        nextPermutation(nums);
        print(nums);
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void print(int[] nums) {
        for (int i : nums) {
            System.out.print("  " + i);
        }
        System.out.println();
    }

}

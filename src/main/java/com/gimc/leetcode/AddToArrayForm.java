package com.gimc.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author: heyin
 * date: 2019-05-20
 * desc: https://leetcode-cn.com/articles/add-to-array-form-of-integer/
 */
public class AddToArrayForm {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0};
        int num = 34;
        List<Integer> integerList = new AddToArrayForm().addToArrayForm(arr, num);
        System.out.println(integerList);
    }
    
    public List<Integer> addToArrayForm(int[] arr, int num) {
        int len = arr.length;
        int cur = num;
        List<Integer> ans = new ArrayList();
        int i = len;
        while (--i >= 0 || cur > 0) {
            if (i >= 0) {
                cur += arr[i];
            }
            ans.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
}

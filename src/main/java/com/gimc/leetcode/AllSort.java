package com.gimc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yin.he
 * @date: 2019-09-17
 * @desc:
 */
public class AllSort {

    /**
     * 递归算法：将数据分为两部分，递归将数据从左侧移右侧实现选择排列
     *
     * @param source
     * @param target
     */
    private static void sort(List<String> source, List<String> target) {
        //将NUM设置为待排列数组的长度即实现选择排列
        for (String obj : target) {
            System.out.print(obj);
        }
        System.out.println();
        for (int i = 0; i < source.size(); i++) {
            List<String> newSource = new ArrayList<>(source);
            List<String> newTarget = new ArrayList<>(target);
            newTarget.add(newSource.get(i));
            newSource.remove(i);
            sort(newSource, newTarget);
        }
    }

    public static void main(String[] args) {
        String[] data = new String[]{"a", "b", "c"};
        List<String> result = new ArrayList<>();
        sort(Arrays.asList(data), result);
        result.forEach(System.out::println);
    }
}

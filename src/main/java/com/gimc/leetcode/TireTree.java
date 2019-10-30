package com.gimc.leetcode;


import java.util.HashMap;

/**
 * author: heyin
 * date: 2018-08-21
 * desc: 前缀数数据结结构和创建
 */
public class TireTree {

    public static void main(String[] args) {
        Trie tries = new Trie();
        String strs[] = {"abca", "abd", "bcc", "abdc", "abc"};

        for (int i = 0; i < strs.length; i++) {
            System.out.println(insertNode(strs[i], tries));
        }
        System.out.println(tries);
    }

    public static boolean insertNode(String str, Trie head) {
        if (str == null || str.length() == 0) {
            return false;
        }
        char chs[] = str.toCharArray();
        int i = 0;
        Trie cur = head;
        while (i < chs.length) {
            if (!cur.children.containsKey(chs[i])) {
                cur.children.put(chs[i], new Trie());
            }
            cur = cur.children.get(chs[i]);
            i++;
        }
        if (cur.children.size() > 0) {
            System.out.println(" trie tree");
            return true;
        }
        return false;
    }
}

class Trie {
    HashMap<Character, Trie> children = new HashMap<>();
}

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
        String strs[] = {"abc", "abd", "b", "abdc"};

        for (int i = 0; i < strs.length; i++) {
            insertNode(strs[i], tries);
        }
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
    boolean isTrie;
    HashMap<Character, Trie> children = new HashMap<Character, Trie>();
}

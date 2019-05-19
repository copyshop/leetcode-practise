package com.gimc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 画家
 * @date 2019-05-19
 * @desc 二叉树的堂兄弟节点
 * https://leetcode-cn.com/articles/cousins-in-binary-tree/
 */
public class CousinsNode {

    Map<Integer, Integer> depth;
    Map<Integer, TreeNode> parent;

    public static void main(String[] args) {
        new CousinsNode().isCousins(null, 3, 4);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap();
        parent = new HashMap();
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}

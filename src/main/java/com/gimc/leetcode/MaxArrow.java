package com.gimc.leetcode;

/**
 * @author: 画家
 * @date: 2019-05-17
 * @desc: 最长相同路径
 */
public class MaxArrow {

    public static void main(String[] args) {
        new MaxArrow();
    }

    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}

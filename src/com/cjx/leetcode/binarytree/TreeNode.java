package com.cjx.leetcode.binarytree;

/**
 * @author cjx
 * @Description LeetCode提供的二叉树
 * @date 2024/2/6 11:16
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

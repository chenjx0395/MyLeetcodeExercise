package com.cjx.leetcode.binarytree;

/**
 * @author cjx
 * @Description E1448. 统计二叉树中好节点的数目【中等】
 * @date 2024/2/6 12:07
 **/
public class E1448 {
    public int goodNodes(TreeNode root) {
        return recursion(root,root.val)+1;
    }

    public int recursion(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int nowMax = root.val;
        int LD = recursion(root.left, Math.max(nowMax, max));
        int RD = recursion(root.right, Math.max(nowMax, max));
        return nowMax >= max ? LD + RD + 1 : LD + RD;

    }
}

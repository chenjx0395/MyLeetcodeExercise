package com.cjx.leetcode.binarytree;

/**
 * @author cjx
 * @Description E1372. 二叉树中的最长交错路径【中等】
 * @date 2024/2/14 10:59
 **/
public class E1372 {
    public int longestZigZag(TreeNode root) {
        int lRes = recursion(root.left,true,false);
        int rRes = recursion(root.right,false,true);
        return Math.max(lRes, rRes);

    }

    public int recursion(TreeNode node, boolean fatherSex, boolean childSex) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (fatherSex != childSex) {
            res++;
        }
        int lRes = recursion(node.left, childSex, false);
        int rRes = recursion(node.right, childSex, true);
        res += Math.max(lRes, rRes);
        return res;
    }
}

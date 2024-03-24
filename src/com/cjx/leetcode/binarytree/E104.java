package com.cjx.leetcode.binarytree;

/**
 * @author cjx
 * @Description E104. 二叉树的最大深度【简单】
 * @date 2024/2/6 11:17
 **/
public class E104 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);
        return Math.max(leftCount, rightCount)+1;
    }

}

package com.cjx.binarytree;

/**
 * @Description 反转二叉树 简单
 * <br/>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @Date 2023/10/18 18:26
 **/
public class E226 {

    //LeetCode提供的二叉树
    static class TreeNode {
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

    public static TreeNode invertTree(TreeNode root) {
        return recursionInvertTree(root);
    }

    private static TreeNode recursionInvertTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode temp = node.left;
        node.left = recursionInvertTree(node.right);
        node.right = recursionInvertTree(temp);
        return node;

    }

    public  static void traverse(TreeNode root){
        if (root == null) {
            return ;
        }
        traverse(root.left);
        System.out.println(root.val);
        traverse(root.right);
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(3,left
                ,new TreeNode(5,null,null));
        traverse(root);
        invertTree(root);


    }

}

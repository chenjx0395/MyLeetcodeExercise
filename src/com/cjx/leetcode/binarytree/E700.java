package com.cjx.leetcode.binarytree;

/**
 * @author cjx
 * @Description 二叉搜索树中的搜索【简单】
 * @date 2024/2/28 8:27
 **/
public class E700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val ){
            return root;
        }
        TreeNode left =  searchBST(root.left , val);
        TreeNode right = searchBST(root.right , val);
        if (left != null){
            return left;
        }else {
            return right;
        }
    }
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null || root.val == val){
            return root;
        }
        return root.val > val ? searchBST1(root.left,val):searchBST1(root.right,val)  ;
    }
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && root.val != val){
            if (root.val > val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        new E700().searchBST(treeNode,2);
    }

}

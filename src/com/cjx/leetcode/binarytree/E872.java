package com.cjx.leetcode.binarytree;

import java.util.ArrayList;

/**
 * @author cjx
 * @Description E872. 叶子相似的树【简单】
 * @date 2024/2/6 11:49
 **/
public class E872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        recursion(root1,list1);
        recursion(root2,list2);
        return list1.equals(list2);
    }

    public void recursion (TreeNode root, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        recursion(root.left, list);
        recursion(root.right, list);
    }
}

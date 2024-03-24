package com.cjx.leetcode.binarytree.breadth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cjx
 * @Description E199. 二叉树的右视图【中等】
 * @date 2024/2/29 7:44
 **/
public class E199 {

    public List<Integer> rightSideView1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.add(root);
        int size = 1;
        while (!queue.isEmpty()) {
            int temp = 0;
            while (size > 0) {
                TreeNode firstNode = queue.remove();
                if (size == 1) {
                    res.add(firstNode.val);
                }
                if (firstNode.left != null) {
                    queue.add(firstNode.left);
                    temp++;
                }
                if (firstNode.right != null) {
                    queue.add(firstNode.right);
                    temp++;
                }
                size--;
            }
            size += temp;
        }
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        dfs(root, 0, res); // 从根节点开始访问，根节点深度是0
        return res;
    }

    private void dfs(TreeNode root, int depth, ArrayList res) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth, res);
        dfs(root.left, depth, res);
    }


    public static void main(String[] args) {
        new E199().rightSideView(new TreeNode(1, new TreeNode(2), new TreeNode(3)));
    }
}

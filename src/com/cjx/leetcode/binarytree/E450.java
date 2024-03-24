package com.cjx.leetcode.binarytree;

/**
 * @author cjx
 * @Description 二叉搜索树 <br/>
 * 450.删除二叉搜索树中的节点
 * @date 2024/2/28 8:53
 **/
public class E450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 根节点不存在直接返回空
        if (root == null) {
            return null;
        }
        // 当前节点是待删除节点
        if (root.val == key) {
            // 左节点节点为空直接返回右节点，反之亦然
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 左右节点都不为空，我们将右节点树下最小值取出，将原树的左子树迁移其左节点，如果右节点不存在左子树，那右节点直接为根节点
            if (root.right.left == null) {
                root.right.left = root.left;
            } else {
                TreeNode left = root.right.left;
                while (left.left != null) {
                    left = left.left;
                }
                left.left = root.left;
            }
            return root.right;
            // 当前节点不是待删除节点
        } else {
            // 删除值可能处于左子树
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }
        }
        return root;


    }


}

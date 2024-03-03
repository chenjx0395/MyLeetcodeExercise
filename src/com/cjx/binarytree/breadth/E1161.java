package com.cjx.binarytree.breadth;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author cjx
 * @Description E1161. 最大层内元素和【中等】
 * @date 2024/3/1 7:49
 **/
public class E1161 {
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; !queue.isEmpty(); i++) {
            int sum = 0;
            int size = queue.size();
            // 取出此层的每个节点
            while (size-- > 0){
                TreeNode node = queue.poll();
                sum += node.val;
                //将节点的子节点加入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (sum > max) {
                res = i;
                max = sum;
            }

        }
        return res;
    }
}

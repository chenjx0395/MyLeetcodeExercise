package com.cjx.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @author cjx
 * @Description E215 数组中的第k个最大元素
 * @date 2024/3/18 8:24
 **/
public class E215 {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        PriorityQueue<Integer> minDeep = new PriorityQueue<>();
        for (int i = 0; i < length; i++) {
            minDeep.offer(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            minDeep.poll();
        }
        return minDeep.poll();
    }
}

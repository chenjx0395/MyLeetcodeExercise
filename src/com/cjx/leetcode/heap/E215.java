package com.cjx.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @author cjx
 * @Description E215 数组中的第k个最大元素
 * @date 2024/3/18 8:24
 **/
public class E215 {
    public int findKthLargest(int[] nums, int k) {
        //1. 建堆
        heapfly(nums);
        //2. 删除k个堆顶元素
        int size = nums.length;
        for (; k > 1 ; k--) {
            remove(nums,size);
            size--;
        }
        //3. 获取堆顶元素并返回
        return remove(nums,size);
    }

    public void heapfly(int[] nums) {
        int size = nums.length;
        //寻找最后一个非叶子节点
        for (int i = size / 2 - 1; i >= 0; i--) {
            //从该节点往前执行下潜操作
            down(nums, i,size);
        }
    }

    public void down(int[] nums, int i,int size) {
        int left = 2 * i + 1;
        int right = left + 1;
        int max = i;
        if (left < size && nums[left] > nums[max]) {
            max = left;
        }
        if (right < size && nums[right] > nums[max]) {
            max = right;
        }
        if (max != i) {
            swap(nums,i,max);
            down(nums,max,size);
        }
    }

    public void swap(int[]nums,int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int remove(int[] nums,int size){
        int max = nums[0];
        swap(nums,0,size - 1);
        size--;
        down(nums,0,size);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(new E215().findKthLargest(nums,2));
    }

}

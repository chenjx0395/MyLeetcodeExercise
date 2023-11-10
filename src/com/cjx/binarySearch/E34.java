package com.cjx.binarySearch;

import java.util.Arrays;

/**
 * @Description 34. 在排序数组中查找元素的第一个和最后一个位置 中等<br/>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * @Author cjx
 * @Date 2023/11/10 17:37
 **/
public class E34 {


    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {// 数组为空的情况
            return new int[]{-1, -1};
        }
        int i = 0, j = nums.length;
        int start = -1, end = -1; //结果值
        while (i < j) {
            int m = (i + j) >>> 1;
            int mv = nums[m];
            if (mv < target){
                i  = m + 1;
            }else if (mv > target){
                j = m;
            }else {
                start = m;
                j = m;
            }
        }
        i = 0;
        j = nums.length;
        while (i < j) {
            int m = (i + j) >>> 1;
            int mv = nums[m];
            if (mv < target){
                i  = m + 1;
            }else if (mv > target){
                j = m;
            }else {
               end = m;
                i  = m + 1;
            }
        }
        return new int[]{start, end};
    }



    public static void main(String[] args) {
        int[] ints = new E34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ints));
    }

}

package com.cjx.binarySearch;

/**
 * @Description 35. 搜索插入位置 简单<br/>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * @Author cjx
 * @Date 2023/11/10 17:21
 **/
public class E35 {

    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            int mv = nums[m];
            if (mv < target){
                i = m + 1;
            }else if(mv > target){
                j = m -1;
            }else {
                return m;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {

    }

}

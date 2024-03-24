package com.cjx.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
 * 并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 * @Date 2023/10/13 18:50
 **/
public class E1 {

    /**
     * 题解1：双重for循环比较，
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j =0;j<nums.length && j != i;j++){
                if (nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }


    /**
     * 题解2：递归+循环
     * @param nums
     * @param target
     * @param i
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        return recursionTwoSum(nums,target,0);
    }
    private int[] recursionTwoSum(int[] nums,int target,int i) {
        if ( i == nums.length){
            return null;
        }
        for (int k = i+1; k < nums.length; k++) {
            if (nums[i] + nums[k] == target ){
                return new int[]{i,k};
            }
        }

        return recursionTwoSum(nums,target,++i);
    }

    /**
     * 题解3：哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i])){
                return new int[]{i,hashMap.get(target-nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }
}

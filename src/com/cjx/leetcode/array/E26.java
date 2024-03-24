package com.cjx.leetcode.array;

/**
 * @Description 26. 删除有序数组中的重复项 【简单】
 * @Author cjx
 * @Date 2023/12/18 11:44
 **/
public class E26 {

    public static int removeDuplicates(int[] nums) {

        int left = 0 ,right = 0, result = 1 ;
        while (right < nums.length){
            if (nums[right] != nums[left]){
                nums[++left] = nums[right];
                result++;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,2});
    }

}

package com.cjx.leetcode.array;

/**
 * @Description E1004. 最大连续1的个数 III【中等】
 * @Author cjx
 * @Date 2024/1/29 13:14
 **/
public class E1004 {
    public int longestOnes(int[] nums, int k) {
        int length = nums.length;
        int max = 0;
        int left = 0 , right = 0;
        while (right < length){
            if (nums[right] == 0){
                if (k < 1){
                    while (left <= right){
                        if (nums[left] == 0){
                            left++;
                            k++;
                            break;
                        }
                        left++;
                    }
                }
                k--;
            }
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new E1004().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));

    }

}

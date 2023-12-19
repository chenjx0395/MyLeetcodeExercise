package com.cjx.array;

/**
 * @Description 283. 移动零 【简单】
 * @Author cjx
 * @Date 2023/12/19 14:55
 **/
public class E283 {

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right] = temp;
            }
            if (nums[right] == 0 && nums[left] != 0) {
                left = right;
            }
            right++;
        }

    }

}

package com.cjx.array;

/**
 * @Description 283. 移动零 【简单】
 * @Author cjx
 * @Date 2023/12/19 14:55
 **/
public class E283 {

    public void moveZeroes1(int[] nums) {
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

    public void moveZeroes2(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return;
        }
        int i = 0, j = 1;
        while (j < length) {
            if (nums[i] == 0 && nums[j] == 0) {
                j++;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
                j++;
            }
        }
    }

    /**
     * 顶级思路
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if (nums == null || length < 1){
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0){
                if (i > j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

}

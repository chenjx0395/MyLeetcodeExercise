package com.cjx.array;

/**
 * @Description 26. 删除有序数组中的重复项 【简单】
 * @Author cjx
 * @Date 2023/12/18 11:44
 **/
public class E26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int left = 0 , result = nums.length ;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] == nums[left]){
                left++;
                result--;
            }
            nums[left] = nums[right];
        }
        return result;
    }

    public static void main(String[] args) {

    }

}

package com.cjx.string;

/**
 * @Description E238. 除自身以外数组的乘积【中等】
 * @Author cjx
 * @Date 2024/1/26 10:08
 **/
public class E238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        //构建左右乘积数组
        int[] left = new int[length], right = new int[length];
        left[0] = 1;
        right[length - 1] = 1;
        //给左数组填值
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        //给右数组填值
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}

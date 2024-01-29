package com.cjx.array;

/**
 * @Description E643. 子数组最大平均数1【简单】
 * @Author cjx
 * @Date 2024/1/29 11:43
 **/
public class E643 {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum / k;
    }

    public static void main(String[] args) {
        new E643().findMaxAverage(new int[]{0,4,0,3,2},1);
    }

}

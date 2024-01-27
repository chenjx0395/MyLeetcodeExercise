package com.cjx.string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description E334. 递增的三元子序列【中等】
 * @Author cjx
 * @Date 2024/1/27 11:49
 **/
public class E334 {
    /**
     * 双循环
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        //判断长度是否满足大于等于3的条件
        if (length < 3) {
            return false;
        }
        int[] leftMin = new int[length];
        leftMin[0] = nums[0];
        for (int i = 1; i < length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        int[] rightMax = new int[length];
        rightMax[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 贪心
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        int length = nums.length;
        if (length < 3){
            return false;
        }
        int first = nums[0] , second = Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            int temp = nums[i];
            //大于二号，代表找到了三号
            if (temp > second){
                return true;
            }else if (temp > first){
                //小于一号，成为二号
                second = temp;
            }else  {
                //比一号还小，成为新一号
                first = temp;
            }
        }
        return false;
    }


}

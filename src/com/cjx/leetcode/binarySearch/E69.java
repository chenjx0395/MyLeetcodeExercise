package com.cjx.leetcode.binarySearch;

/**
 * @Description 69. x 的平方根 【简单】
 * @Author cjx
 * @Date 2023/12/14 9:18
 **/
public class E69 {
    public static int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        if (x == 1){
            return 1;
        }
        int left = 0,right = x,result = 0;
        while (left <= right) {
            int mid = left + ((right - left)>>1);
            if ((long)mid*mid > x){
                right = mid -1;
            }else {
                result = mid;
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        mySqrt(2147395599);
    }
}

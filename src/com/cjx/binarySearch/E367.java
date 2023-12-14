package com.cjx.binarySearch;

/**
 * @Description 367. 有效的完全平方数 【简单】
 * @Author cjx
 * @Date 2023/12/14 9:43
 **/
public class E367 {
    public boolean isPerfectSquare(int num) {
        long l = 0, r = num;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mid * mid <= num) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r * r == num;
    }
}

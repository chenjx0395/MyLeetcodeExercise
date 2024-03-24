package com.cjx.leetcode.prefixAnd;

/**
 * @Description E1732. 找到最高海拔【简单】
 * @Author cjx
 * @Date 2024/1/30 9:05
 **/
public class E1732 {
    public int largestAltitude(int[] gain) {
        int res = 0 , sum = 0;
        for (int i : gain){
            sum += i;
            res = Math.max(res,sum);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new E1732()
                .largestAltitude
                        (new int []{44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81}));
    }
}

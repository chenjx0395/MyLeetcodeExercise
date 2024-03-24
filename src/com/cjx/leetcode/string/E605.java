package com.cjx.leetcode.string;

/**
 * @Description E605. 种花问题【简单】
 * @Author cjx
 * @Date 2024/1/25 10:10
 **/
public class E605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int spare = 0;
        // 找出花坛还空余的种花位
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0 && n <= 1 || n == 0;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0) {
                    if (judgement(0, flowerbed[i + 1])) {
                        spare++;
                        flowerbed[i] = 1;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (judgement(flowerbed[i - 1], 0)) {
                        spare++;
                        flowerbed[i] = 1;
                    }
                } else {
                    if (judgement(flowerbed[i - 1], flowerbed[i + 1])) {
                        spare++;
                        flowerbed[i] = 1;
                    }
                }
            }
        }
        // 比较空余位和需求量
        return spare >= n;
    }

    private boolean judgement(int left, int right) {
        return left == 0 && right == 0;
    }

    /**
     * 跳格子思路
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else {
                if (i == len - 1 || flowerbed[i + 1] == 0) {
                    n--;
                    i += 2;
                } else {
                    i += 3;
                }

            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        new E605().canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2);
    }
}

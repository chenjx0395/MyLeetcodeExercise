package com.cjx.array;

import java.util.Arrays;

/**
 * @Description 合并两个有序数组 简单 <br>
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * @Date 2023/10/17 15:27
 **/


public class E88 {

    /**
     * 题解1：利用双指针分别比较
     * @param nums1
     * @param m - nums1的数组长度
     * @param nums2
     * @param n - nums2的数组长度
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums1 = new int[m];
        System.arraycopy(nums1,0,newNums1,0,m);
        //1.设置两个指针
        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (p1 == m){
                nums1[i] = nums2[p2++];
            } else if (p2 == n) {
                nums1[i] = newNums1[p1++];
            }else if (newNums1[p1]<=nums2[p2]){
                nums1[i] = newNums1[p1];
                p1++;
            }else {
                nums1[i] = nums2[p2];
                p2++;
            }
        }
    }

    public static void main(String[] args) {
       int []  nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3,n = 3;
        merge(nums1,m,nums1,n);
    }
}

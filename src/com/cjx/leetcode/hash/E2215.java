package com.cjx.leetcode.hash;

import java.util.HashSet;
import java.util.List;

/**
 * @Description E2215. 找出两数组的不同【简单】
 * @Author cjx
 * @Date 2024/1/30 10:00
 **/
public class E2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        for (int i : nums2){
            set1.remove(i);
        }
        for (int i : nums1){
            set2.remove(i);
        }
        return List.of(List.copyOf(set1),List.copyOf(set2));

    }

    public static void main(String[] args) {
        System.out.println(new E2215().findDifference(new int []{1,2,3},new int []{2,4,6}));
    }
}

package com.cjx.leetcode.heap;

import java.util.TreeSet;

/**
 * @author cjx
 * @Description E2336.无限集中的最小数字【中】
 * @date 2024/3/25 7:39
 **/
public class E2336 {


    static class SmallestInfiniteSet {

        private int thres;
        private TreeSet<Integer> set;

        public SmallestInfiniteSet() {
            thres = 1;
            set = new TreeSet<Integer>();
        }

        public int popSmallest() {
            if (set.isEmpty()) {
                int ans = thres;
                ++thres;
                return ans;
            }
            int ans = set.pollFirst();
            return ans;
        }

        public void addBack(int num) {
            if (num < thres) {
                set.add(num);
            }
        }



       
    }
}
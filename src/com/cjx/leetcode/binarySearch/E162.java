package com.cjx.leetcode.binarySearch;

/**
 * @author cjx
 * @Description E162.寻找峰值【中】
 * @date 2024/3/17 9:18
 **/
public class E162 {
    public int findPeakElement(int[] nums) {
        //判断nums[0] 和nums[n-1]是否满足条件
        int length = nums.length;
        int l = 0, r = length - 1;
        if (length == 1 || nums[l + 1] < nums[l]) {
            return l;
        }
        if (nums[r - 1] < nums[r]) {
            return r;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = nums[mid];
            if (mid == 0) {
                l = mid + 1;
                continue;
            }
            if (mid == length - 1) {
                r = mid - 1;
                continue;
            }
            if (nums[mid - 1] > midVal) {
                // 往左侧二分
                r = mid - 1;
            } else if (nums[mid + 1] > midVal) {
                // 往右侧二分
                l = mid + 1;
            } else {
                // 满足题意，返回索引
                return mid;
            }
        }
        return -1;
    }
}

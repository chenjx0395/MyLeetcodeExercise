package com.cjx.leetcode.binarySearch;

/**
 * @Description <h3>二分查找。</h3>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * @Date 2023/11/7 18:01
 **/
public class E704 {

    /**
     * 1：基础版的二分查找<br>
     * 对于左右区间采用左闭右开的方式，所以i赋值为0，且比较后调整位置要在half的基础上加1，
     * j则赋值为nums.length，比较后调整位置直接为half就行。
     * 循环判断条件设置为i < j,原因：这时 j 指向的不是查找目标，如果还加 i==j 条件，
     * 就意味着 j 指向的还会再次比较，找不到时，会死循环
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 结果索引值，-1代表未找到
     */
    public int search1(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        int half;
        while (i < j) {
            half = (i + j) >>> 1;
            if (nums[half] < target) {
                i = half + 1;
            } else if (nums[half] > target) {
                j = half;
            } else {
                return half;
            }
        }
        return -1;
    }

    /**
     * 2:改进版的二分查找<br>
     * 这种是左闭右闭的区间，所以j要赋值成nums.length，
     * 且比较不一样后，i要赋值成half+1，j则赋值成j-1，因为
     * 这时的j索引代表也是没被查找到，待查找的索引。
     * 所以循环比较条件也要设置成i<=j
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 结果索引值，-1代表未找到
     */
    public int search2(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        int half;
        while (i <= j) {
            half = (i + j) >>> 1;
            if (nums[half] < target) {
                i = half + 1;
            } else if (nums[half] > target) {
                j = half - 1;
            } else {
                return half;
            }
        }
        return -1;
    }


    /**
     * 3 二分查找平衡版
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length; //边界区域
        int half;
        while (1 < j - i) {// j-i代表待查找元素
            half = (i + j) >>> 1;
            if (target < nums[half]) {
                j = half;
            } else {
                i = half;
            }
        }
        return (nums[i] == target) ? i : -1;
    }

    /**
     * 4 java版的二分查找
     * @param a
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return
     */
    public static int binarySearch0(long[] a, int fromIndex, int toIndex, long key) {
        int i = fromIndex;
        int j = toIndex;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            long midval = a[mid];

            if (midval < key) {
                i = mid + 1;
            } else if (midval > key) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return -(i + 1);
    }



    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(new E704().search2(nums, -1));
    }

}

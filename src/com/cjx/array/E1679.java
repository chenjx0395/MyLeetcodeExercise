package com.cjx.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description E1679. K 和数对的最大数目
 * @Author cjx
 * @Date 2024/1/29 9:56
 **/
public class E1679 {

    public int maxOperations1(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int count = 0;
        int left = 0, right = length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            } else {
                left++;
                right--;
                count++;
            }
        }
        return count;
    }

    /**
     * 哈希
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>(length);
        for (int num : nums) {
            Integer i = hashMap.getOrDefault(num, 0);
            hashMap.put(num, ++i);
        }
        for (int num : nums) {
            int x = k - num;
            if (hashMap.get(num) < 1){
                continue;
            }
            hashMap.put(num, hashMap.get(num) - 1);

            if (hashMap.containsKey(x) && hashMap.get(x) > 0) {
                count++;
                hashMap.put(x, hashMap.get(x) - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new E1679().maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3);
    }

}

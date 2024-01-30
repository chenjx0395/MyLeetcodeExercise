package com.cjx.array;

/**
 * @Description E1493. 删掉一个元素以后全为1的最长数组【中等】
 * @Author cjx
 * @Date 2024/1/30 8:41
 **/
public class E1493 {
    public int longestSubarray(int[] nums) {
        int length = nums.length;
        int res = 0;
        int left = 0, right = 0;
        boolean flag = true;
        for (; right < length; right++) {
            if (nums[right] == 0) {
                if (flag) {
                    flag = false;
                    continue;
                }
                res = Math.max(res, right - left);
                while (left < right){
                    if (nums[left++] == 0){
                        break;
                    }
                }
            }
        }
        res = Math.max(res, right - left);
        return res - 1;
    }

    public static void main(String[] args) {
        System.out.println("new E1493().longestSubarray() = " + new E1493().longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }

}

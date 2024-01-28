package com.cjx.array;

/**
 * @Description E11. 盛最多水的容器【中等】
 * @Author cjx
 * @Date 2024/1/28 11:00
 **/
public class E11 {
    public int maxArea(int[] height) {
        int length = height.length;
        int max = 0 , i = 0,j = length -1;
        while (i<j) {
                int width = j - i;
                max = Math.max(max, Math.min(height[i], height[j]) * width);
                if ( height[i] < height[j]){
                    i++;
                }else {
                    j--;
                }
        }
        return max;
    }
}

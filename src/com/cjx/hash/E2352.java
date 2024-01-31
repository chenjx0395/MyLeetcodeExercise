package com.cjx.hash;

import java.util.*;

/**
 * @Description E2352. 相等行列对【中等】
 * @Author cjx
 * @Date 2024/1/31 9:38
 **/
public class E2352 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> cnt = new HashMap<List<Integer>, Integer>();
        for (int[] row : grid) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int num : row) {
                arr.add(num);
            }
            cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr.add(grid[i][j]);
            }
            res +=cnt.getOrDefault(arr,0);
        }
        return res;
    }




    public static void main(String[] args) {
        System.out.println(new E2352().equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
    }

}

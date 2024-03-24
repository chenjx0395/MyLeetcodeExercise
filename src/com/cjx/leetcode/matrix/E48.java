package com.cjx.leetcode.matrix;

import java.util.Arrays;

/**
 * @Description 旋转图像 【中等】
 * @Author cjx
 * @Date 2023/12/10 11:29
 **/
public class E48 {

    /**
     * 1.使用辅助数组 <br/>
     * 构造新数组，将旧行赋值给新列
     *
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

    /**
     * 2.旋转图像
     *
     * @param matrix 矩阵
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arrays[][] = {{1, 2}, {3, 4}};
        rotate(arrays);
        System.out.println(Arrays.deepToString(arrays));
    }

}

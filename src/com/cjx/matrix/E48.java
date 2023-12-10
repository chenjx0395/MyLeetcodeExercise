package com.cjx.matrix;

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

    public static void rotate(int[][] matrix) {
        int [] row = new int[matrix.length];
        int [] col = new int[matrix.length];
        for (int i = 0; i < 4; i++) {

            if (i%4==0){
                for (int j = matrix.length -1 ;j >= 0 ; j--) {
                    col[j] = matrix[j][matrix.length-1];
                    matrix[j][matrix.length-1] = matrix[0][j];
                }
                /*for (int j = 0; j < matrix.length; j++) {

                    col[j] = matrix[j][matrix.length - 1];
                    matrix[j][matrix.length - 1] =  matrix[0][j];
                }*/
            }
            if (i%4==1){
                for (int j = matrix.length -1 ;j >= 0 ; j--) {
                    row[j] = matrix[matrix.length-1][matrix.length -1 - j];
                    matrix[matrix.length-1][matrix.length -1 - j] = col[matrix.length -1 - j];
                }
            }


           /* //第一次
            for (int j = 0; j < matrix.length; j++) {
                row[j] = matrix[i][j];
            }
            for (int j = matrix.length - 1; j > 0; j--) {
                col[matrix.length - 1 - j] = matrix[j][matrix.length -1];
            }
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][matrix.length - 1] = row[j];
            }
            //第二次
            for (int j = 0; j < matrix.length; j++) {
                row[j] = matrix[matrix.length - 1][j];
            }
            for (int j = 0; j < matrix.length; j++) {
                matrix[matrix.length - 1][j] = col[j];
            }*/
        }
    }

    public static void main(String[] args) {
        int arrays[][] = {{1,2},{3,4}};
        rotate(arrays);
        System.out.println(Arrays.deepToString(arrays));
    }

}

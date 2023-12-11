package com.cjx.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 矩阵置零【中等】
 * @Author cjx
 * @Date 2023/12/11 11:22
 **/
public class E73 {

    /**
     * 1.辅助矩阵
     *
     * @param matrix 矩阵
     */
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] temp = new int[n][m];
        List<int []> recording = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix [i][j] != 0){
                    temp [i][j] = matrix [i][j];
                }else {
                    recording.add(new int[]{i,j});
                }
            }
        }
        for (int [] nums : recording){
            setToZero(temp,nums[0],nums[1]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = temp[i][j];
            }
        }

    }

    /**
     * 辅助函数：用于将i行，j列的辅助矩阵的值设置为0
     *
     * @param temp
     * @param i
     * @param j
     */
    public static void setToZero(int[][] temp, int i, int j) {
        int n = temp.length;
        int m = temp[0].length;
        for (int k = 0; k < n; k++) {
            temp[k][j] = 0;
            for (int l = 0; l < m; l++) {
            temp[i][l] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int [][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);

    }

}

package com.cjx.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 矩阵置零【中等】
 * @Author cjx
 * @Date 2023/12/11 11:22
 **/
public class E73 {

    /**
     * 1.记录覆盖
     *
     * @param matrix 矩阵
     */
    public static void setZeroes1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<int[]> recording = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    recording.add(new int[]{i, j});
                }
            }
        }
        for (int[] nums : recording) {
            setToZero(matrix, nums[0], nums[1]);
        }
    }

    /**
     * 2.使用2个标记变量
     *
     * @param matrix
     */
    public static void setZeroes2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean rowFlag = false, colFlag = false;
        //检查第一行是否有0
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }
        //检查第一列是否有0
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }
        //检查剩下矩阵是否含0，用第一行第一列记录
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[j][i] == 0) {
                    matrix[0][i] = matrix[j][0] = 0;
                }
            }
        }
        //将是0的行列置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[j][0] == 0 || matrix[0][i] == 0){
                    matrix[j][i] = 0;
                }
            }
        }
        //将有0的第一行置0
        if (rowFlag) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
        //将有0的第一列置0
        if (colFlag) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    /**
     * 一个标记变量
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean colFlag = false;
        //检查列是否有0
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0){
//                colFlag ==
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
        int[][] matrix = new int[][]{{1, 0, 2, 1}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);

    }

}

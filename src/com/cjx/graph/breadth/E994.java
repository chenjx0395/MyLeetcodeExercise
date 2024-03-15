package com.cjx.graph.breadth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cjx
 * @Description E994.腐烂的橘子【中】
 * @date 2024/3/15 8:00
 **/
public class E994 {
    private Queue<int[]> queue = new LinkedList<>();
    private final int[][] direction = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    private boolean isInfection ;
    public int orangesRotting(int[][] grid) {
        // 设置记录好橘子的数量
        int goodOrange = 0;
        // 1.遍历查找初始阶段所有烂橘子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
                if (grid[i][j] == 1){
                    goodOrange++;
                }
            }
        }
        //判断初始状态是否有好橘子，没有直接返回0
        if (goodOrange == 0){
            return 0;
        }
        if (queue.isEmpty()){
            //代表没有烂橘子，直接返回-1
            return -1;
        }
        //开始感染橘子
        return bfs(grid,1,goodOrange);

    }
    private int bfs(int[][] grid,int minute,int goodOrange) {
        // 遍历取出坏橘子的位置，感染起上下左右的空间。
        int size = queue.size();

        while (size > 0){
            int[] poll = queue.poll();
            // 对四个范围感染
            int row = poll[0] , col = poll[1];
            goodOrange -= infection(grid,row + direction[0][0] , col+ direction[0][1]);
            goodOrange -= infection(grid,row + direction[1][0] , col+ direction[1][1]);
            goodOrange -= infection(grid,row + direction[2][0] , col+ direction[2][1]);
            goodOrange -= infection(grid,row + direction[3][0] , col+ direction[3][1]);
            //感染一轮判断一次是否可以结束
            if (goodOrange == 0){
                //好橘子没有直接返回结果
                return ++minute;
            }
            size--;
        }
        // 所有烂橘子感染一轮后依旧存在好橘子，且还有烂橘子没开始感染便开始下一轮感染
        if (queue.isEmpty()){
            return -1;
        }
        return bfs(grid,++minute,goodOrange);
    }

    private int infection(int[][] grid,int row,int col){
        if (row < 0 || col < 0 || row >= grid.length || col >=  grid[0].length){
            return 0;
        }
        if (grid[row][col] == 0){
            return 0;
        }
        if (grid[row][col] == 2){
            return 0;
        }
        if (grid[row][col] == 1){
            grid[row][col] = 2;
            queue.add(new int []{row,col});
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int [][] pram =  new int[][]{{2,1}};
        System.out.println(new E994().orangesRotting(pram));

    }
}

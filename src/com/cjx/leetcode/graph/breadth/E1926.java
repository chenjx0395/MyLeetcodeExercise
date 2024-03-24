package com.cjx.leetcode.graph.breadth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cjx
 * @Description E1926 迷宫中离出口最近的出口【中等】
 * @date 2024/3/13 8:44
 **/
public class E1926 {
    int res = 0;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] mazeBlog ;
    int rowEnd = 0;
    int colEnd = 0;
    public int nearestExit(char[][] maze, int[] entrance) {
        // 1.队列记录下一次须移动的点位
        // 2.移动时按顺时针将其他满足条件的点位加入队列，
        // 2.1 如果满足处于边界条件，则直接得解
        // 2.2 加入队列的点须满足－该点未被加入过队列，该点不是墙，该点没有越界
        // 3.记录后开启下一次递归，终止条件1. 队列未空－代表没有合适的出口 2. 找到出口
        // 4.边界点的特点：1. 横坐标为0， 2. 纵坐标为0，3. 横坐标为最大值，4. 纵坐标为最大值
        // 初始化标记数组
        colEnd= maze[0].length;
        rowEnd = maze.length;
        mazeBlog = new boolean[rowEnd][colEnd];
        queue.add(entrance);
        if (bfs(maze)){
            return res;
        }

        return -1;
    }
    private boolean bfs(char[][] maze){
        if (queue.isEmpty()){
            return false;
        }
        int size = queue.size();
        while (size > 0){
            // 取出点肯定不是出口或未满足点
            int[] poll = queue.poll();
            mazeBlog[poll[0]][poll[1]] = true;
            boolean j1 = judgement(maze, poll[0] - 1, poll[1]);
            boolean j2 = judgement(maze, poll[0], poll[1] + 1);
            boolean j3 = judgement(maze, poll[0] + 1, poll[1]);
            boolean j4 = judgement(maze, poll[0], poll[1] - 1);
            if (j1||j2||j3||j4){
                res++;
                return true;
            }
            size--;
            res++;
        }
        return bfs(maze);

    }

    private boolean judgement(char[][] maze,int  row,int col){
        if (row < 0 || row > rowEnd || col < 0 || col > colEnd){
            return false;
        }
        if (maze[row][col] == '.' && !mazeBlog[row][col]){
            // 代表找到了出口
            if (row == 0 || row == rowEnd -1|| col == 0 || col == colEnd -1){
                return true;
            }
            // 将此点加入队列，且标记也改变
            queue.add(new int[]{row,col});

        }
        return false;
    }

    public static void main(String[] args) {
       char[][]  maze = new char[][]{{'+','+','+'},{'.','.','.'},{'+','+','+'}}
               ;
        System.out.println(new E1926().nearestExit(maze,new int[]{1,0}));
    }
}

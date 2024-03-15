package com.cjx.graph.deep;

import java.util.ArrayList;

/**
 * @author cjx
 * @Description
 * @date 2024/3/5 14:44
 **/
public class E547 {
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, cities, i);
                provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, cities, j);
            }
        }
    }

    public static void main(String[] args) {
        new E547().findCircleNum(new int[][]{new int []{1,1,0},new int []{1,1,0},new int []{0,0,1}});
    }
}

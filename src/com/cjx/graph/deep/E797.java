package com.cjx.graph.deep;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cjx
 * @Description 797.所有可能的路径
 * @date 2024/3/4 7:46
 **/
public class E797 {

    private  List<List<Integer>> res = new ArrayList<>();
    private List<Integer> paths = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph,0);
        return res;
    }

    private void dfs(int [][] graph,int node){
        paths.add(node);
        if (node == graph.length -1){
            res.add(new ArrayList<>(paths));
            return;
        }
        for (int n : graph[node]){
            dfs(graph,n);
            paths.remove(paths.size() -1);
        }
    }



}

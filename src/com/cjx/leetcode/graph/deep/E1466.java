package com.cjx.leetcode.graph.deep;


/**
 * @author cjx
 * @Description
 * @date 2024/3/6 8:25
 **/
public class E1466 {
        int res = 0;
    public int minReorder(int n, int[][] connections) {
        // 1.遍历路线，如果是【0，n－1】则值互换，反之不变，记录n－1的值
        //到下一个路线时判断路线中是否包含该值，不包含则代表此条路线已到尽头
        // 2.一条路线到尽头后从新开始判断
        // 3.记录改变的次数
        dfs(connections,-1,0);
        return res;
    }

    private void dfs(int[][] connections,int node,int i){
        if (i  == connections.length){
            return;
        }
        int[] connection = connections[i];
        // 如果是第一次，那么直接判断0的位置，给node赋值，进入下一次判断
        if (node == -1){
            if (connection[1] == 0){
                node = connection[0];
            }else {
                node = connection[1];
                res++;
            }
            dfs(connections,node,++i);
            return;
        }
        // 不是第一次，则判断当前路线是否和上一个城市相连
        if (connection[0] == node){
            // 路线第一个城市是上一个城市，则路线要逆转
            node = connection[1];
            res++;
        }else if(connection[1] == node){
            // 路线第二个城市是上一个城市，则路线不用逆转
            node = connection[0];
        }else {
            // 回到原始状态
            node = -1;
            dfs(connections,node,i);
            return;
        }
        dfs(connections,node,++i);
    }
    public static void main(String[] args) {
        E1466 e1466 = new E1466();
        System.out.println(e1466.minReorder(6, new int[][]{new int[]{1, 0}, new int[]{1, 2}, new int[]{2, 3},
                new int[]{4, 2}}));
        System.out.println();
    }

}

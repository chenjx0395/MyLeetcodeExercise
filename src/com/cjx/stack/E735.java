package com.cjx.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description E735. 小行星碰撞【中等】
 * @Author cjx
 * @Date 2024/1/31 11:32
 **/
public class E735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                // aster 是否存在
                alive = stack.peek() < -aster;
                // 栈顶行星爆炸
                if (stack.peek() <= -aster) {
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(new E735().asteroidCollision(new int[]{10, 2, -5})));
    }
}

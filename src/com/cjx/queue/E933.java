package com.cjx.queue;

import java.util.LinkedList;

/**
 * @Description
 * @Author cjx
 * @Date 2024/2/1 12:01
 **/
public class E933 {

    private LinkedList<Integer> queue;

    public E933(){
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.addLast(t);
        int temp = t - 3000;
        while (queue.getFirst() < temp){
            queue.removeFirst();
        }
        return queue.size();
    }

}

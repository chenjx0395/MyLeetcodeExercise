package com.cjx.datastructure.priorityquque;

import com.cjx.datastructure.queue.Queue;

/**
 * @author cjx
 * @Description 基于有序数组实现的优先级队列
 * @date 2024/3/24 9:52
 **/
@SuppressWarnings("unchecked")
public class PriorityQueue2<E extends Priority> implements Queue<E> {

    public Priority[] array;
    public int size;

    public PriorityQueue2() {
    }

    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }


    @Override
    public boolean offer(E value) {
        //1. 判断空间是否已满
        if (isFull()) {
            return false;
        }
        insert(value);
        size++;
        return true;
    }

    @Override
    public E poll() {
        //1. 判断数组是否为空
        if (isEmpty()) {
            return null;
        }
        int removeIndex = --size;
        E e = (E) array[removeIndex];
        //2. 删除对应元素
        array[removeIndex] = null;
        return e;
    }

    @Override
    public E peek() {
        //1. 判断数组是否为空
        if (isEmpty()) {
            return null;
        }
        //2. 查找优先级最高元素的索引
        return (E) array[size - 1];
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    /**
     * 插入元素
     * @param e 元素
     */
    private void insert(E e){
        int i = size - 1;
        while (i >= 0 && array[i].backPriority() < e.backPriority()){
            array[i+1] = array[i];
            i--;
        }
        array[i+1] = e;
    }
}

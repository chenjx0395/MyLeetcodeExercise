package com.cjx.datastructure.priorityquque;

import com.cjx.datastructure.priorityquque.Priority;
import com.cjx.datastructure.queue.Queue;

/**
 * @author cjx
 * @Description 基于无序数组实现的优先级队列
 * @date 2024/3/24 9:52
 **/
@SuppressWarnings("unchecked")
public class PriorityQueue1<E extends Priority> implements Queue<E> {

    public Priority[] array;
    public int size;

    public PriorityQueue1() {
    }

    public PriorityQueue1(int capacity) {
        array = new Priority[capacity];
    }


    @Override
    public boolean offer(E value) {
        //1. 判断空间是否已满
        if (isFull()) {
            return false;
        }
        array[size++] = value;
        return true;
    }

    @Override
    public E poll() {
        //1. 判断数组是否为空
        if (isEmpty()) {
            return null;
        }
        int maxIndex = selectMax();
        E e = (E) array[maxIndex];
        //2. 删除对应元素
        remove(maxIndex);
        return e;
    }

    @Override
    public E peek() {
        //1. 判断数组是否为空
        if (isEmpty()) {
            return null;
        }
        //2. 查找优先级最高元素的索引
        return (E) array[selectMax()];
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
     * 返回优先级最大的元素的索引
     *
     * @return 索引
     */
    private int selectMax() {
        //定义双指针，利用保留枚举比较的方式查找优先级最大的元素
        int max = 0, i = 1;
        while (i < size) {
            //取当前索引的优先级与max索引的优先级进行比较
            if (array[i].backPriority() > array[max].backPriority()) {
                max = i;
            }
            i++;
        }
        return max;
    }

    /**
     * 删除数组的索引位置的元素
     *
     * @param index 索引
     */
    private void remove(int index) {
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        // help GC
        array[--size] = null;
    }
}

package com.cjx.datastructure.priorityquque;

import com.cjx.datastructure.queue.Queue;

/**
 * @author cjx
 * @Description 基于大顶堆实现的优先级队列
 * @date 2024/3/24 9:52
 **/
@SuppressWarnings("unchecked")
public class PriorityQueue3<E extends Priority> implements Queue<E> {

    public Priority[] array;
    public int size;

    public PriorityQueue3() {
    }

    public PriorityQueue3(int capacity) {
        array = new Priority[capacity];
    }


    @Override
    public boolean offer(E value) {
        //1. 判断空间是否已满
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;
        //2. 比较子父节点大小
        while (child > 0 && value.backPriority() > array[parent].backPriority()) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = value;
        return true;
    }

    @Override
    public E poll() {
        //1. 判断数组是否为空
        if (isEmpty()) {
            return null;
        }
        E e = (E) array[0];
        //2. 交换头尾节点
        swap(0, size - 1);
        //3. 删除尾节点
        array[--size] = null;
        //4. 下潜
        down(0);
        return e;

    }

    /**
     * 下潜方法
     */
    private void down(int par) {
        // 计算当前节点的左右孩子节点
        int left = 2 * par + 1;
        int right = 2 * par + 2;
        int max = par;
        if (left < size && array[left].backPriority() > array[max].backPriority()) {
            max = left;
        }
        if (right < size && array[right].backPriority() > array[max].backPriority()) {
            max = right;
        }
        // 有孩子比父亲大
        if (max != par) {
            swap(max, par);
            down(max);
        }
    }

    @Override
    public E peek() {
        //1. 判断数组是否为空
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];

    }

    /**
     * 交换数组的两个元素
     *
     * @param i 元素1
     * @param j 元素2
     */
    private void swap(int i, int j) {
        Priority temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }


}

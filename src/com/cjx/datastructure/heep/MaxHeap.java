package com.cjx.datastructure.heep;

import java.awt.desktop.QuitResponse;
import java.security.PublicKey;
import java.util.Arrays;

/**
 * 大顶堆
 */
public class MaxHeap {
    int[] array;
    int size;

    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 获取堆顶元素
     *
     * @return 堆顶元素
     */
    public int peek() {
        return array[0];
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     */
    public int poll() {
        //1. 堆顶元素和堆尾元素互换
        int i = array[0];
        swap(0, size - 1);
        size--;
        //2. 对堆顶元素执行下潜操作
        down(0);
        return i;
    }

    /**
     * 删除指定索引处元素
     *
     * @param index 索引
     * @return 被删除元素
     */
    public int poll(int index) {
        //1. 将索引处元素和堆尾元素互换
        int i = array[index];
        swap(index, size - 1);
        down(index);
        size--;
        return i;
    }

    /**
     * 替换堆顶元素
     *
     * @param replaced 新元素
     */
    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }

    /**
     * 堆的尾部添加元素
     *
     * @param offered 新元素
     * @return 是否添加成功
     */
    public boolean offer(int offered) {
        if (size == array.length) {
            return false;
        }
        size++;
        up(offered, size);
        return true;
    }


    /**
     * 将 offered 元素上浮: 直至 offered 小于父元素或到堆顶
     *
     * @param offered 元素
     * @param index   索引
     */
    private void up(int offered, int index) {
        int child = index;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (array[parent] < array[child]) {
                array[child] = array[parent];
            } else {
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    /**
     * 建堆方法
     */
    private void heapify() {
        //找到最后一个非叶子节点
        for (int i = size / 2 - 1; i >= 0; i--) {
            // 对每个节点执行下潜操作
            down(i);
        }
    }


    /**
     * 下潜
     *
     * @param parent 下潜元素的索引
     */
    private void down(int parent) {
        int max = parent;
        int left = parent * 2 + 1;
        int right = left + 1;
        if (left < size && array[max] < array[left]) {
            max = left;
        }
        if (right < size && array[max] < array[right]) {
            max = right;
        }
        if (max != parent) {
            swap(parent, max);
            down(max);
        }
    }


    /**
     * 交换两个索引处的元素
     *
     * @param i 索引1
     * @param j 索引2
     */
    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {

        int[] array = {2, 3, 1, 7, 6, 4, 5};
        MaxHeap heap = new MaxHeap(array);
        System.out.println(Arrays.toString(heap.array));

        while (heap.size > 1) {
            heap.swap(0, heap.size - 1);
            heap.size--;
            heap.down(0);
        }

        System.out.println(Arrays.toString(heap.array));
    }
}

package com.cjx.array;

/**
 * @Description27. 移除元素  简单
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。<br>
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * @Date 2023/10/14 10:07
 **/
public class E27 {

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0 || nums[0] == val && nums.length ==1){
            return 0;
        }
        //1.创建头尾指针
        int head = 0;
        int tail = nums.length-1;
        int count = nums.length;
       //头指针和尾指针一起个val值进行比较，根据比较结果，做出相应动作
        while (head < tail){
            if (nums[head] == val && nums[tail] != val){
                nums[head++] = nums[tail--];
                if (head == tail && nums[head] == val){ //如果是奇数数组，那但tail==head时，要对最后一个元素进行判断
                    count--;
                }
                count--;
            } else if (nums[head] !=val && nums[tail] == val) {
                head++;
                tail--;
                if (head == tail && nums[head] == val){
                    count--;
                }
                count--;
            } else if (nums[head] != val && nums[tail] != val) {
                head++;
            }else { // 头指针和尾指针的值都和删除值一样
                if (head+1==tail){
                    count--;
                }
                tail--;
                count --;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{3,3};
        for (int i = 0; i < removeElement(nums, 3); i++) {
            System.out.println(nums[i]);
        }
    }

}

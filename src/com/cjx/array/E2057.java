package com.cjx.array;

/**
 * @Description 给你一个下标从 0 开始的整数数组 nums ，返回 nums 中满足 i mod 10 == nums[i] 的最小下标 i ；
 * 如果不存在这样的下标，返回 -1 。
 * x mod y 表示 x 除以 y 的 余数 。
 * @Date 2023/10/13 8:34
 **/
public class E2057 {

    /**
     * 题解1：循环
     * @param nums
     * @return
     */
    public static int smallestEqual(int [] nums){
        //1.设置nums长度for循环
        for (int i = 0; i < nums.length; i++) {
        //2.套用比较公式，成功则返回下标
            if (i % 10 == nums[i]){
                return i;
            }
        }
        //3.循环结束，返回-1
        return -1;
    }

    /**
     * 题解2：递归
     * @param nums
     * @return
     */
    public static int smallestEqual1(int [] nums){
            return recursionSmallestEqual1(nums,0);
    }
    private static int recursionSmallestEqual1(int [] nums,int index){
        //递归结束条件1：递归到头，返回-1
        if (nums.length == index){
            return -1;
        }
        //递归结束条件2：满足比较公式结束递归，返回索引值
        if (index % 10 == nums[index]){
            return index;
        }
        return recursionSmallestEqual1(nums,++index);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3,1,1,3,4,543};
        System.out.println(smallestEqual1(ints));


    }

}

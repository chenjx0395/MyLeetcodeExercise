package com.cjx.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 最长公共前缀<br>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Date 2023/10/16 16:41
 **/
public class E14 {

    /**
     * 题解1：暴力枚举
     * <br> 1.获取字符串数组的最小字符长度
     * <br> 2.比较每个单词的第i个字母是否一样
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {

        StringBuffer publicString = new StringBuffer();
        //1.
        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
            }
        }
        //2.
        for (int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return String.valueOf(publicString);
                }
            }
            publicString.append(c);
        }
        return String.valueOf(publicString);
    }

    public static String longestCommonPrefix(String[] strs) {
        //1.获取每个字符串在大数组的索引值
        List index = new ArrayList();
        int sum = 0;
        for (int i = 0; i < strs.length-1; i++) {
            index.add(sum + strs[i].length());
            sum += strs[i].length();
        }
        //2.将字符串数组转换为字符数组
        StringBuffer bigString = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            bigString.append(strs[i]);
        }
        char[] chars = bigString.toString().toCharArray();
        //3.进行比较

        return null;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}

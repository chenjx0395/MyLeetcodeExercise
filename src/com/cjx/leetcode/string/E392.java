package com.cjx.leetcode.string;

/**
 * @Description E392. 判断子序列【简单】
 * @Author cjx
 * @Date 2024/1/28 10:45
 **/
public class E392 {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int i = 0 , j = 0;
        while (j < tLength && i < sLength){
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == sLength;
    }
}

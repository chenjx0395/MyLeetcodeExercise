package com.cjx.leetcode.stack;
import java.util.Stack;

/**
 * @Description ## E2390. 从字符串中移除星号【中等】
 * @Author cjx
 * @Date 2024/1/31 10:55
 **/
public class E2390 {
    public String removeStars1(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        StringBuilder res = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c != '*'){
                stack.push(c);
                continue;
            }
            if (stack.empty()){
                continue;
            }
            stack.pop();
        }
        for (Character c : stack){
            res.append(c);
        }
        return String.valueOf(res);

    }

    public String removeStars(String s) {
        int length = s.length();
        StringBuilder res = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '*'){
                /*if (!res.isEmpty()){
                res.deleteCharAt(res.length()-1);
                }*/
                continue;
            }
            res.append(c);
        }
        return String.valueOf(res);

    }



    public static void main(String[] args) {
        System.out.println(new E2390().removeStars("leet**cod*e"));
    }
}

package com.cjx.leetcode.stack;

import java.util.*;

/**
 * @Description E394. 字符串解码【中等】
 * @Author cjx
 * @Date 2024/2/1 9:35
 **/
public class E394 {
    public String decodeString(String s) {
        int length = s.length();
        Stack<Character> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                int num = 0;
                if (!numStack.isEmpty()){
                    numStack.pop();
                }
                //取数字
                for (int j = 1; !numStack.isEmpty() && numStack.peek() != '['; j *= 10) {
                    num += (numStack.pop() - 48) * j;
                }
                //取字符
                StringBuilder tempBuilder = new StringBuilder();
                for (int i = 0; charStack.peek() != '['; i++) {
                    tempBuilder.append(charStack.pop());
                }
                tempBuilder.reverse();
                String tempStr = tempBuilder.toString().repeat(num);
                charStack.pop();

                    for (char c1 : tempStr.toCharArray()) {
                        charStack.push(c1);
                    }

            } else {
                if (c >= 48 && c <= 57) {
                    numStack.push(c);
                } else if (c == '[') {
                    numStack.push(c);
                    charStack.push(c);
                } else {
                    charStack.push(c);
                }
            }
        }
        while (!charStack.isEmpty()) {
            res.append(charStack.pop());
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new E394().decodeString("3[a]2[bc]"));
    }
}

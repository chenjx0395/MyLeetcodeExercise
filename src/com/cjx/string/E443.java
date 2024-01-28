package com.cjx.string;

import java.util.concurrent.BlockingDeque;

/**
 * @Description E443. 压缩字符串【中等】
 * @Author cjx
 * @Date 2024/1/28 9:20
 **/
public class E443 {

    public int compress(char[] chars) {
        int length = chars.length;
        if (length == 1){
            return  length;
        }
        StringBuffer buffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            char iChar = chars[i];
            int count = 1;
            int j = i+1;
            for (; j < length; j++) {
                char jChar = chars[j];
                if (iChar == jChar){
                    count++;
                }else {
                    break;
                }
            }
            i = j-1;
            if (count == 1){
                buffer.append(iChar);
            }else {
                buffer.append(iChar).append(count);
            }
        }
        for (int i = 0; i < buffer.length(); i++) {
            chars[i] = buffer.charAt(i);
        }
        return buffer.length();
    }



}

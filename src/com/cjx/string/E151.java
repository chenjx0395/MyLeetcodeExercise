package com.cjx.string;

import java.util.Arrays;

/**
 * @Description E151. 反转字符串中的单词【中等】
 * @Author cjx
 * @Date 2024/1/26 9:10
 **/
public class E151 {

    public String reverseWords(String s) {
        //转换成字符数组
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        String[] stringArray = new String[length];
        int stringTag = 0;
        //从前到后捕获每个单词
        for (int i = 0; i < length; i++) {
            //遇到空格跳过
            if (charArray[i] == ' ') {
                continue;
            } else {
                //遇到字母则开始记录该单词区间，然后写入字符串数组
                int j = i + 1;
                for (; j < length; j++) {
                    //单词尾跳出循环，找到单词区间了
                    if (charArray[j] == ' ') {
                        break;
                    }
                }
                char[] wordChars = Arrays.copyOfRange(charArray, i, j);
                stringArray[stringTag++] = new String(wordChars);
                i = j;
            }
        }
        //将捕获单词拼凑成字符串
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = stringTag - 1; i >= 0; i--) {
            stringBuffer.append(stringArray[i]).append(" ");
        }
        return String.valueOf(stringBuffer.deleteCharAt(stringBuffer.length()-1));
    }

    public static void main(String[] args) {
        System.out.println(new E151().reverseWords("the sky is blue"));
    }


}

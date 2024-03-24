package com.cjx.leetcode.string;

/**
 * @Description E345. 反转字符串中的元音字母【简单】
 * @Author cjx
 * @Date 2024/1/25 11:14
 **/
public class E345 {

    public String reverseVowels(String s) {
        int len = s.length();
        int start = 0  , end = len-1;
        boolean flagStart = false , flagEnd = false;
        char [] chars = s.toCharArray();
        if (len < 2){
            return s;
        }
        while (start < end){
            if (filtration(chars[start])){
                flagStart = true;
            }
            if (filtration(chars[end])){
                flagEnd = true;
            }
            if (flagStart && flagEnd){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                flagStart = false;
                flagEnd = false;
            }
            if (!flagStart){
                start++;
            }
            if (!flagEnd){
                end--;
            }
        }
        return new String(chars) ;
    }

    /**
     * 判断字符s是否是元音字母
     * @param s
     * @return 是 返回 true
     */
    private boolean filtration(char s) {
        char[] vowel = {'a', 'e', 'i', 'o', 'u' };
        if (s >= 65 && s <= 90) {
            s += 32;
        }
        return s == vowel[0] || s == vowel[1] || s == vowel[2] || s == vowel[3] || s == vowel[4];
    }

    public static void main(String[] args) {
        System.out.println("new E345().reverseVowels(\"hello\") = " + new E345().reverseVowels("hello"));
    }

}

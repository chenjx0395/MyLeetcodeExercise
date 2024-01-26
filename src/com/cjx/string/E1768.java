package com.cjx.string;



/**
 * @Description 交替合并字符串 【简单】
 * @Author cjx
 * @Date 2024/1/18 10:12
 **/
public class E1768 {

    public static String mergeAlternately(String word1, String word2) {
        StringBuffer newString = new StringBuffer();
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int p1 = 0, p2 = 0;
        for (int i = 0; i < s1.length + s2.length; i++) {
            //出现一个数组到头的情况，代表新字符串已构建完成
            if (p1 == s1.length && p2 == s2.length){
                break;
            }
            //奇数让s1添加入新字符串
            if (i % 2 == 0) {
                //判断s1是否还有未添加值
                if (p1 == s1.length) {
                    //s1无值，将s2剩余值全赋值给新字符串
                    while (p2 != s2.length) {
                        newString.append(s2[p2++]);
                    }
                } else {
                    //s1有值，正常赋值
                    newString.append(s1[p1++]);
                }
            } else {
                //偶数让s2添加入新字符串
                //判断s2是否还有未添加值
                if (p2 == s2.length) {
                    //s2无值，将s1剩余值全赋值给新字符串
                    while (p1 != s1.length) {
                        newString.append(s1[p1++]);
                    }
                } else {
                    //s2有值，正常赋值
                    newString.append(s2[p2++]);
                }
            }
        }
        return String.valueOf(newString);
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc","cba"));
    }

}

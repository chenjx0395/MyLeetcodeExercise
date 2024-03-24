package com.cjx.leetcode.string;

/**
 * @Description 字符串的最大公因子 【简单】
 * @Author cjx
 * @Date 2024/1/19 9:30
 **/
public class E1071 {

    public static String gcdOfStrings(String str1, String str2) {
        //定义因子字符串
        String factor = "";
        int str1Len = str1.length(), str2Len = str2.length();
        for (int i = Math.min(str1Len, str2Len); i > 0; i--) {
            //1.找一个因子
            String tempFactor = str1.substring(0, i);
            int step = tempFactor.length();
            //2.判断该因子是否是两个字符串的公因子
            //判断字符串长度是否可以整除
            if (str1Len % step != 0 || str2Len % step != 0) {
                continue;
            }
            boolean flag = true;
            for (int j = 0; j <= str1Len - step; j += step) {
                //截取字符串判断是否满足公因子
                if (!tempFactor.equals(str1.substring(j, j + step))) {
                    flag = false;
                    break;
                }
            }
            for (int j = 0; j <= str2Len - step; j += step) {
                //截取字符串判断是否满足公因子
                if (!tempFactor.equals(str2.substring(j, j + step))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                factor = tempFactor;
                break;
            }
        }
        return factor;
    }

    /**
     * 利用辗转相除法优化
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings1(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        String T = str1.substring(0, gcd(len1, len2));
        if (check(T, str1) && check(T, str2)) {
            return T;
        }
        return "";
    }

    public boolean check(String t, String s) {
        int lenx = s.length() / t.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 1; i <= lenx; ++i) {
            ans.append(t);
        }
        return ans.toString().equals(s);
    }

    public int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }


    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABABAB", "ABAB"));
    }

}

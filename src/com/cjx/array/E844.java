package com.cjx.array;

import java.util.Arrays;

/**
 * @Description 844. 比较含退格的字符串 【简单】
 * @Author cjx
 * @Date 2023/12/19 15:49
 **/
public class E844 {

    private static final char BACKSPACE = '#';

    public static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    /*private static int checkBackspace(int p , char[] nums,int temp){
        if (nums[p] != BACKSPACE || nums[p-1] != BACKSPACE){
            p -= temp;
            return p;
        }
        return checkBackspace(--p,nums,++temp);
    }*/

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##", "c#d#"));
    }

}

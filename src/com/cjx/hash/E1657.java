package com.cjx.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description E1657.确定两个字符串是否接近【中等】
 * @Author cjx
 * @Date 2024/1/30 10:59
 **/
public class E1657 {
    public boolean closeStrings(String word1, String word2) {
        int[] count1 = new int[26], count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] > 0 && count2[i] == 0 || count1[i] == 0 && count2[i] > 0) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }
}

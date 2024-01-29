package com.cjx.string;

/**
 * @Description E1456. 定长子串中元音的最大数目【中等】
 * @Author cjx
 * @Date 2024/1/29 12:21
 **/
public class E1456 {

    private static final char[] CHARS = new char[]{'a', 'e', 'i', 'o', 'u'};

    public int maxVowels(String s, int k) {
        char[] charArray = s.toCharArray();
        int vowal = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(charArray[i])){
                vowal++;
            }
        }
        int maxVowal = vowal;
        for (int i = k; i < charArray.length; i++) {
            if (maxVowal == k){
                break;
            }
            if (isVowel(charArray[i - k])){
                vowal--;
            }
            if (isVowel(charArray[i])){
                vowal++;
                maxVowal  = Math.max(maxVowal,vowal);
            }
        }
        return maxVowal;

    }

    private boolean isVowel(char c){
        for (char aChar : CHARS) {
            if (c == aChar) {
                return true;
            }
        }
        return false;
    }

}

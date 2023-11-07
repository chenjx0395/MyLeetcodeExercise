package com.cjx.string;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description 如果两个字符串 word1 和 word2 中从 'a' 到 'z' 每一个字母出现频率之差都 不超过 3 ，
 * 那么我们称这两个字符串 word1 和 word2 几乎相等 。
 * <p>
 * 给你两个长度都为 n 的字符串 word1 和 word2 ，
 * 如果 word1 和 word2 几乎相等 ，请你返回 true ，否则返回 false 。
 * <p>
 * 一个字母 x 的出现 频率 指的是它在字符串中出现的次数。
 * @Date 2023/10/12 13:37
 **/
public class E2068 {

    /**
     * 思路1：从a开始循环遍历，循环中记录两个字符串的字母出现次数，外循环结束一次，就比较一次，
     * 情况不对，直接return false
     * @param word1
     * @param word2
     * @return
     */
    public static boolean comparisonString(String word1, String word2) {
        for (int i = 97; i <= 122; i++) { //外循环，从a开始
            int word1Size = 0; //设置变量，记录字母出现次数
            int word2Size = 0;
            for (int n = 0; n < word1.length(); n++) {
                if (word1.charAt(n) == i) {
                    word1Size++;
                }
                if (word2.charAt(n) == i) {
                    word2Size++;
                }
            }
            if (Math.abs(word1Size-word2Size)>3){
                return false;
            }
        }
        return true;
    }

    /**
     * 思路2：
     * 1.创建一个空间大小为26的数组count，这个数组的0-25会代表word1和word2的所有字符差值<br>
     * 2.让word1和word2的每个字符和字符‘a’相减：这个相减值作为count的索引值，让它自增或自减<br>
     * 3.循环遍历count，做绝对值处理，有大于3的值就返回false，没有则最终返回true<br>
     * @param word1
     * @param word2
     * @return
     */
    public static boolean comparisonString2(String word1, String word2) {
        int count [] = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count[word1.charAt(i) - 'a']++;
            count[word2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (Math.abs(count[i])>3){
                return false;
            }
        }
        return true;
    }

    /**
     * 题解3：哈希表
     * @param word1
     * @param word2
     * @return
     */
    public static boolean comparisonString3(String word1, String word2){
        Map<Character,Integer> hashMap = new HashMap<Character,Integer>();
        //1.给word1的每个字母做key插入到哈希表中，并用哈希表的值来记录字母出现的个数
        for (int i = 0; i < word1.length(); i++) {
            Character word1Key =  word1.charAt(i);
            Character word2Key =  word2.charAt(i);
            //如果字母一样，直接退出本次循环
            if (word1Key == word2Key){
                continue;
            }
            //比较哈希表的key有，值+1或-1，没有，键入
            if (hashMap.containsKey(word1Key)){
                hashMap.put(word1Key,hashMap.get((word1Key))+1);
            }else {
                hashMap.put(word1Key,1);
            }
            if (hashMap.containsKey(word2Key)){
                hashMap.put(word2Key,hashMap.get((word2Key))-1);
            }else {
                hashMap.put(word2Key,-1);
            }
        }
        //2.遍历哈希表的值，看是否出现大于3或小于-3的值
        for (Map.Entry<Character,Integer> entry:hashMap.entrySet()){
            if (Math.abs(entry.getValue())>3){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
       String word1 = "abcd", word2 = "zdzz";
        System.out.println(comparisonString3(word1, word2));
    }


}

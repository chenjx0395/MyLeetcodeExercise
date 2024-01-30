package com.cjx.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Description E1207. 独一无二的出现次数【简单】
 * @Author cjx
 * @Date 2024/1/30 10:40
 **/
public class E1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : arr){
            Integer value = hashMap.getOrDefault(i, 0);
            hashMap.put(i,++value);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (Map.Entry<Integer,Integer> i : hashMap.entrySet()){
            if (!hashSet.add(i.getValue())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new E1207().uniqueOccurrences(new int[]{1,2,7,2,2,2,2});
    }

}

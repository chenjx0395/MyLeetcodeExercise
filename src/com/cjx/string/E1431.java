package com.cjx.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description E1431.拥有最多糖果的孩子【简单】
 * @Author cjx
 * @Date 2024/1/25 9:52
 **/
public class E1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length;
        List<Boolean> result = new ArrayList<Boolean>(len);
        //找出原糖果数最大的孩子
        int max = maxCandies(candies);
        //遍历数组，判断当前孩子的糖果数加上额外糖果数后比较原max糖果数
        for (int i = 0; i < len; i++) {
            if (candies[i] + extraCandies >= max){
                result.add(true);
            }else {
                result.add(false);
            }
        }
        return result;
    }

    private int maxCandies(int[] candies){
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] >= max){
                max = candies[i];
            }
        }
        return max;
    }
}

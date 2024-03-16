package com.cjx.binarySearch;

import java.util.Arrays;

/**
 * @author cjx
 * @Description E2300.咒语和药水的成功对数【中】
 * @date 2024/3/16 10:31
 **/
public class E2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int potionsSize = potions.length;
        int l, r, mid;
        int res[] = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            l = 0;
            r = potionsSize - 1;
            mid = 0;
            int spell = spells[i];
            int potionIndex = -1;
            while (l <= r) {
                mid = l + (r - l) / 2;
                //判断中间药水的情况
                long midRes = (long) spell * potions[mid];
                //中间药水满足
                if (midRes >= success) {
                    if (mid != 0) {
                        //判断左位是否不满足
                        if ((long) potions[mid - 1] * spell < success) {
                            potionIndex = mid ;
                            break;
                        }
                    }
                    r = mid-- - 1;
                    //中间药水不满足
                } else {
                    if (mid != potionsSize - 1) {
                        if ((long) potions[mid + 1] * spell > success) {
                            potionIndex = mid + 1;
                            break;
                        }
                    }
                    //判断右位是否满足
                    l = mid++ + 1;
                }
            }
            // 代表找到了最大的不满足值的位序
            if (potionIndex != -1) {
                res[i] = potionsSize - potionIndex;
            }
            // 代表全是满足的药水
            if (mid < l) {
                res[i] = potionsSize;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int spells[] = new int[]{5, 1, 3}, potions[] = new int[]{1, 2, 3, 4, 5}, success = 7;
        System.out.println(Arrays.toString(new E2300().successfulPairs(spells, potions, success)));
    }
}

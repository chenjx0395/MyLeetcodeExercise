package com.cjx.leetcode.queue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description E649. Dota2 参议院
 * @Author cjx
 * @Date 2024/2/1 12:08
 **/
public class E649 {
    public String predictPartyVictory1(String senate) {
        int rSize = 0, dSize = 0;
        char[] charArray = senate.toCharArray();
        for (char c : charArray) {
            if (c == 'R') {
                rSize++;
            } else {
                dSize++;
            }
        }
        LinkedList<Character> queue = new LinkedList<>();
        for (char c : charArray) {
            queue.addLast(c);
        }
        int i = 0;
        while (rSize != 0 && dSize != 0) {
            if (i >= queue.size()) {
                i = 0;
            }
            if (queue.get(i++) == 'R') {
                //删除逻辑 ： 先判断其后有没有其他参议员，要删第一个，没有删全局第一个

                queue.removeFirstOccurrence('D');
                dSize--;
            } else {
                queue.removeFirstOccurrence('R');
                rSize--;
            }
        }
        return rSize > dSize ? "Radiant" : "Dire";

    }

    public String predictPartyVictory(String senate) {
        char[] charArray = senate.toCharArray();
        int length = charArray.length;
        boolean flagR = true, flagD = true;
        int flag = 0;
        while (flagR && flagD) {
            flagR = false;
            flagD = false;
            for (int i = 0; i < length; i++) {
                char c = charArray[i];
                if (c == 'R') {
                    if (flag < 0) {
                        charArray[i] = 0;
                    } else {
                        flagR = true;
                    }
                    flag++;


                }
                if (c == 'D') {
                    if (flag > 0) {
                        charArray[i] = 0;
                    } else {
                        flagD = true;
                    }
                    flag--;
                }
            }
        }
        return flagR ? "Radiant" : "Dire";
    }

    public boolean isCYY(LinkedList<?> queue, int first, int last) {
        Object[] array = queue.toArray();
        System.out.println(Arrays.toString(array));
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new E649().predictPartyVictory("DRRD"));
        LinkedList<Character> objects = new LinkedList<>();
        objects.add('a');
        objects.add('b');
        objects.add('c');
        new E649().isCYY(objects, 0, 0);
    }
}

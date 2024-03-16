package com.cjx.binarySearch;

/**
 * @author cjx
 * @Description E374.猜数字大小【简】
 * @date 2024/3/16 10:04
 **/
public class E374 {

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */
    private int guess(int num) {
        return 0;
    }


    public int guessNumber(int n) {
        int l = 1 , r = n;
        while (l <= r){
            int mid = l + (r - l) / 2;
            int guess = guess(mid);
            if (guess  == -1 ){
                r = mid - 1;
            }else if ( guess == 1){
                l = mid + 1;
            }else {
                return mid;
            }
        }
        return 0;
    }
}

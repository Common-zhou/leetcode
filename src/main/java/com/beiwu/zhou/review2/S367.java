package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-21 14:31
 */
public class S367 {

    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long doubleMid = (long) mid * mid;
            if (doubleMid == num) {
                return true;
            } else if (doubleMid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }
}

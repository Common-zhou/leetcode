package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-08 16:52
 */
public class S367 {

    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;

        while (left <= right) {
            long mid = (left + right) / 2;
            long doubleMid = mid * mid;
            if (doubleMid == num) {
                return true;
            } else if (doubleMid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {

    }
}

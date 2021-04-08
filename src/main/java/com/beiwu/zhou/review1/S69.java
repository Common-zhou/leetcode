package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-08 16:38
 */
public class S69 {

    public int mySqrt(int x) {
        // 二分法
        long left = 1, right = x;

        while (left <= right) {
            long mid = (left + right) / 2;
            long doubleMid = mid * mid;
            if (doubleMid == x) {
                return (int) mid;
            } else if (doubleMid > x) {
                right = (int) (mid - 1);
            } else if (doubleMid < x) {
                left = (int) (mid + 1);
            }
        }
        return (int) right;
    }

    public static void main(String[] args) {
        S69 s69 = new S69();
        System.out.println(s69.mySqrt(2147483647));
    }
}

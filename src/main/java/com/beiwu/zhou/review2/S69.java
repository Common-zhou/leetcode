package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-21 14:09
 */
public class S69 {

    public int mySqrt(int x) {
        // 二分法查找
        int left = 1;
        int right = x;

        while (left <= right) {
            // 防止数字越界
            int mid = left + (right - left) / 2;
            long doubleMid = (long) mid *(long) mid;
            if (doubleMid == x) {
                return mid;
            } else if (doubleMid > x) {
                right = mid - 1;
            } else if (doubleMid < x) {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        S69 s69 = new S69();
        System.out.println(s69.mySqrt(2147483647));
    }

}

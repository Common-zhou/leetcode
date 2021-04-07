package com.beiwu.zhou.NO0_100;

/**
 * @author zhoubing
 * @date 2021-04-07 17:40
 */
public class SolutionNo69 {

    public int mySqrt(int x) {
        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long doubleMid = (long)mid * mid;
            if (doubleMid == x) {
                return mid;
            } else if (doubleMid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        SolutionNo69 solution = new SolutionNo69();
        System.out.println(solution.mySqrt(2147395599));
    }
}

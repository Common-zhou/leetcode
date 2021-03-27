package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-03-27 23:55
 */
public class S70 {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    public int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int first = 1;
        int second = 2;
        int start = 2;
        while (start < n) {
            int tmp = first + second;
            first = second;
            second = tmp;
            start++;
        }
        return second;
    }


    public static void main(String[] args) {

    }
}

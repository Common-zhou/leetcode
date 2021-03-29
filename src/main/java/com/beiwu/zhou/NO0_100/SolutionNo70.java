package com.beiwu.zhou.NO0_100;

/**
 * @author zhoubing
 * @date 2021-03-20 11:19
 */
public class SolutionNo70 {
    public int climbStairs(int n) {
        int first = 1;
        int second = 2;
        int current = 2;

        if (n <= 2) {
            return n;
        }

        while (current < n) {
            int currentNum = first + second;
            first = second;
            second = currentNum;
            current++;
        }

        return second;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionNo70().climbStairs(4));
    }
}

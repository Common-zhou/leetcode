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


    public int climbStairs2(int n) {
        // n级台阶 动态规划
        // 只能从n-1 级台阶跨一步上来 或者从n-2级台阶跨两步上来
        if (n == 1 || n == 2) {
            return n;
        }
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];

    }

    public static void main(String[] args) {
        System.out.println(new SolutionNo70().climbStairs(4));
    }
}

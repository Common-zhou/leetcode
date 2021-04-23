package com.beiwu.zhou.NO201_300;

/**
 * @author zhoubing
 * @date 2021-04-24 00:08
 */
public class SolutionNo279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 首先将i定义为i
            dp[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        SolutionNo279 solution = new SolutionNo279();
        System.out.println(solution.numSquares(12));
    }


}

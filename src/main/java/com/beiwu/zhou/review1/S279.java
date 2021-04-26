package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-26 11:01
 */
public class S279 {
    public int numSquares(int n) {
        // 它代表当前数字 的最小数量
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            int sqrt = (int) Math.floor(Math.sqrt(i));
            for (int j = 1; j <= sqrt; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        S279 s279 = new S279();
        System.out.println(s279.numSquares(12));
    }

}

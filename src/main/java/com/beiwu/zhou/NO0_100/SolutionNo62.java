package com.beiwu.zhou.NO0_100;

/**
 * @author zhoubing
 * @date 2021-04-12 11:02
 */
public class SolutionNo62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }


        // 第多少行  从m-1 -> 1
        for (int i = m - 2; i >= 0; i--) {
            // 第多少列  从n-1 -> 1
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }

        return dp[0][0];
    }


    public int uniquePaths3(int m, int n) {
        // 从第一行开始 dp方程代表 从0,0到 当前位置的走法
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
        SolutionNo62 solution = new SolutionNo62();
        solution.uniquePaths(3, 4);
    }
}

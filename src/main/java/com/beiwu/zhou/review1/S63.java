package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-26 14:28
 */
public class S63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 0) {
                // 无障碍
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < col; i++) {
            if (obstacleGrid[0][i] == 0) {
                // 无障碍
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    // 无障碍
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[row - 1][col - 1];

    }

}

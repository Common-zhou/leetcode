package com.beiwu.zhou.NO0_100;

/**
 * @author zhoubing
 * @date 2021-04-12 11:26
 */
public class SolutionNo63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] res = new int[row][col];

        for (int i = row - 1; i >= 0; i--) {
            if (obstacleGrid[i][col - 1] == 0) {
                res[i][col - 1] = i == row - 1 ? 1 : res[i + 1][col - 1];
            } else {
                res[i][col - 1] = 0;
            }
        }

        for (int i = col - 1; i >= 0; i--) {
            if (obstacleGrid[row - 1][i] == 0) {
                res[row - 1][i] = i == col - 1 ? 1 : res[row - 1][i + 1];
            } else {
                res[row - 1][i] = 0;
            }
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    res[i][j] = res[i + 1][j] + res[i][j + 1];
                } else {
                    res[i][j] = 0;
                }
            }
        }

        return res[0][0];

    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        // 从头往下
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) {
            // 开头或者结尾为障碍物  失败
            return 0;
        }

        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < col; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        SolutionNo63 solution = new SolutionNo63();
        int path =
            solution.uniquePathsWithObstacles1(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        System.out.println(path);
    }
}

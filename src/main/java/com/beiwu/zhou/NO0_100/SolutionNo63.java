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

    public static void main(String[] args) {
        SolutionNo63 solution = new SolutionNo63();
        int path = solution.uniquePathsWithObstacles(new int[][] {{0, 0}, {0, 1}});
        System.out.println(path);
    }
}

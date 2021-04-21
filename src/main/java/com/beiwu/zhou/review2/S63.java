package com.beiwu.zhou.review2;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-04-21 11:39
 */
public class S63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        // 如果 最后一行 最后一个是障碍物 那直接结束
        if (obstacleGrid[row - 1][col - 1] == 1) {
            // 最后一个为障碍物 没有路径
            return 0;
        }

        int[][] path = new int[row][col];
        path[row - 1][col - 1] = 1;

        // 先处理边界
        for (int i = row - 2; i >= 0; i--) {
            if (obstacleGrid[i][col - 1] == 0) {
                // 如果当前位置没有障碍物 直接将它的下一个赋值给它
                path[i][col - 1] = path[i + 1][col - 1];
            }
        }
        for (int i = col - 2; i >= 0; i--) {
            if (obstacleGrid[row - 1][i] == 0) {
                // 如果当前位置没有障碍物 直接将它的下一个赋值给它
                path[row - 1][i] = path[row - 1][i + 1];
            }
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    path[i][j] = path[i + 1][j] + path[i][j + 1];
                }
            }
        }

        return path[0][0];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        // 这个数组代表的是 从0,0 到当前位置 有多少种走法
        int[][] path = new int[row][col];

        path[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 0) {
                // 没有障碍物
                path[i][0] = path[i - 1][0];
            }
        }

        for (int i = 1; i < col; i++) {
            if (obstacleGrid[0][i] == 0) {
                // 没有障碍物
                path[0][i] = path[0][i - 1];
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    // 没有障碍物
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }

        return path[row - 1][col - 1];
    }

    public static void main(String[] args) {
        S63 s63 = new S63();
        int i = s63.uniquePathsWithObstacles2(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        System.out.println(i);
    }


}

package com.beiwu.zhou.review2;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-04-21 11:28
 */
public class S62 {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m + 1][n + 1];

        // 先处理边界  最后一行 最后一列  全为1
        for (int i = 1; i < m + 1; i++) {
            path[i][n] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            path[m][i] = 1;
        }
        // 从 m-1,n-1位置出发 不断向上走 dp[i][j] = dp[i+1][j] + dp[i][j+1]

        for (int i = m - 1; i > 0; i--) {
            for (int j = n - 1; j > 0; j--) {
                path[i][j] = path[i + 1][j] + path[i][j + 1];
            }
        }

        return path[1][1];

    }

    public static void main(String[] args) {
        S62 s62 = new S62();
        System.out.println(s62.uniquePaths(3, 3));
    }

}

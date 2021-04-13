package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-13 14:22
 */
public class S200 {
    public int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    // 如果是1  代表什么？ 代表当前是陆地 那么从当前出发 标记所有能到达的位置
                    markConnectionLand(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void markConnectionLand(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;

        // terminal
        if (i < 0 || i >= row || j < 0 || j > col) {
            // 越界  不再标记
            return;
        }

        // process data
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            markConnectionLand(grid, i + 1, j);
            markConnectionLand(grid, i - 1, j);
            markConnectionLand(grid, i, j + 1);
            markConnectionLand(grid, i, j - 1);
        }
        // drill down

        // reverse data

    }

}

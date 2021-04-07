package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-07 15:11
 */
public class S200 {

    public int numIslands(char[][] grid) {
        // 使用dfs  如果可以走 就一直走 并将走过的地方标记为已走过(0)
        int number = 0;

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 遍历行和列
                if (grid[i][j] == '1') {
                    // 代表这里是陆地 标记
                    number++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return number;

    }

    private void dfs(char[][] grid, int x, int y, int row, int col) {
        if (x < 0 || y < 0 || x >= row || y >= col) {
            return;
        }
        if (grid[x][y] == '1') {
            // 如果当前位置是陆地
            grid[x][y] = '0';
            dfs(grid, x - 1, y, row, col);
            dfs(grid, x + 1, y, row, col);
            dfs(grid, x, y - 1, row, col);
            dfs(grid, x, y + 1, row, col);
        }
    }

    public static void main(String[] args) {
        S200 s200 = new S200();
        int numIslands = s200.numIslands(new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
            }
        );
        System.out.println(numIslands);
    }

}

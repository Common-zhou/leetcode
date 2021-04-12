package com.beiwu.zhou.NO0_100;

/**
 * @author zhoubing
 * @date 2021-04-08 18:35
 */
public class SolutionNo74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0, right = row * col - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int curRow = mid / col;
            int curCol = mid % col;
            if (matrix[curRow][curCol] == target) {
                return true;
            } else if (matrix[curRow][curCol] > target) {
                // 比target大 说明 应该在左边寻找
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return false;

    }


    public static void main(String[] args) {
        SolutionNo74 solution = new SolutionNo74();
        boolean b = solution
            //.searchMatrix(new int[][] {{1, 1}}, 2);
            .searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3);
        System.out.println(b);
    }

}

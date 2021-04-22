package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-22 10:27
 */
public class S74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midRow = mid / col;
            int midCol = mid % col;
            if (target == matrix[midRow][midCol]) {
                return true;
            } else if (target > matrix[midRow][midCol]) {
                // 如果target比较大  向右找
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        S74 s74 = new S74();
        boolean exist = s74.searchMatrix(new int[][]{{1,1}}, 2);
        //boolean exist = s74.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 34);
        System.out.println(exist);
    }

}

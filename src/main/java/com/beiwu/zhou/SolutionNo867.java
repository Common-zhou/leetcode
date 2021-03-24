package com.beiwu.zhou;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-03-23 16:13
 */
public class SolutionNo867 {
    public int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0][];
        int[][] newMatrix = new int[matrix[0].length][];

        // 1  2 3 列
        for (int i = 0; i < matrix[0].length; i++) {
            int[] column = new int[matrix.length];
            //
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            newMatrix[i] = column;
        }

        return newMatrix;
    }

    public static void main(String[] args) {
        SolutionNo867 solution = new SolutionNo867();
        int[][] transpose = solution.transpose(new int[][] {{1, 2, 3}, {4, 5, 6}});

        for (int[] ints : transpose) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

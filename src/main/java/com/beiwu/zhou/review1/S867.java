package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-03-25 00:51
 */
public class S867 {
    public int[][] transpose(int[][] matrix) {

        // 之前是 3*2的  现在 横应该是2
        int[][] transposeMatrix = new int[matrix[0].length][];

        for (int i = 0; i < matrix[0].length; i++) {
            // 之前是 3*2
            // 现在是 2*3
            int[] row = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                row[j] = matrix[j][i];
            }
            transposeMatrix[i] = row;
        }

        return transposeMatrix;
    }


    public static void main(String[] args) {

    }
}

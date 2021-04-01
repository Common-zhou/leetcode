package com.beiwu.zhou.review2;

import java.util.Arrays;

/**
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * <p>
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * @author zhoubing
 * @date 2021-04-01 15:35
 */
public class S867 {

    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][];

        // 循环列数  假如是一个 2*3得矩阵   现在循环出来得数字就是 0-1-2 3列
        for (int i = 0; i < matrix[0].length; i++) {
            int[] row = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                row[j] = matrix[j][i];
            }
            result[i] = row;
        }
        return result;
    }


    public static void main(String[] args) {
        S867 s867 = new S867();
        int[][] transpose = s867.transpose(new int[][] {{1, 2, 3}, {4, 5, 6}});
        for (int[] ints : transpose) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

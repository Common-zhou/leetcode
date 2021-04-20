package com.beiwu.zhou;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-04-13 17:52
 */
public class SolutionNo1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        // 将text1 和text2 看成两个数组
        // text1 = "abcde", text2 = "ace"
        // 形成一个二维数组 该二维数组的作用是这样的  [i,j] 标识 text1到i位置 text2到j位置 的最长公共子串
        int t1Length = text1.length();
        int t2Length = text2.length();

        int[][] res = new int[t1Length + 1][t2Length + 1];

        // 处理边界
        for (int i = 0; i < t1Length; i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                res[i][0] = 1;
            } else if (i != 0) {
                res[i][0] = res[i - 1][0];
            }
        }

        for (int i = 0; i < t2Length; i++) {
            if (text2.charAt(i) == text1.charAt(0)) {
                res[0][i] = 1;
            } else if (i != 0) {
                res[0][i] = res[0][i - 1];
            }
        }


        for (int i = 1; i < t1Length; i++) {
            for (int j = 1; j < t2Length; j++) {
                // 如果两个位置相等 那么当前位置就是 f[i-1,j-1] +1
                if (text1.charAt(i) == text2.charAt(j)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
                // 否则就是 f(i-1,j) 或者f(i,j-1)的较大者

            }
        }
        //for (int[] re : res) {
        //    System.out.println(Arrays.toString(re));
        //}


        return res[t1Length - 1][t2Length - 1];

    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] res = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i][j - 1], res[i - 1][j]);
                }
            }
        }
        return res[m][n];

    }

    public static void main(String[] args) {
        SolutionNo1143 solution = new SolutionNo1143();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }

}

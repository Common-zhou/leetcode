package com.beiwu.zhou;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-04-12 16:54
 */
public class SolutionNo1147 {

    public int largestCommonString(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int[][] res = new int[s1Length][s2Length];
        for (int i = 0; i < s1Length; i++) {
            if (s2.charAt(0) == s1.charAt(i)) {
                res[i][0] = 1;
            } else {
                if (i != 0) {
                    res[i][0] = res[i - 1][0];
                }
            }
        }

        for (int i = 0; i < s2Length; i++) {
            if (s1.charAt(0) == s2.charAt(i)) {
                res[0][i] = 1;
            } else {
                if (i != 0) {
                    res[0][i] = res[0][i - 1];
                }
            }
        }

        for (int i = 1; i < s1Length; i++) {
            for (int j = 1; j < s2Length; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    //如果两者的末尾相同 那结果就是 res(i-1,j-1) + 1
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    // 如果两者不相同 那结果就是max(res(i-1,j) , res(i,j-1))
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }


        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }


        return 0;
    }

    public static void main(String[] args) {
        SolutionNo1147 solution = new SolutionNo1147();
        int i = solution.largestCommonString("ABAZDC", "BACBAD");
        System.out.println(i);
    }
}

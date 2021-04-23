package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-14 21:41
 */
public class S1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int t1Length = text1.length();
        int t2Length = text2.length();

        int[][] res = new int[t1Length + 1][t2Length + 1];

        for (int i = 1; i <= t1Length; i++) {
            for (int j = 1; j <= t2Length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }


        return res[t1Length][t2Length];

    }

    public static void main(String[] args) {
        S1143 s1143 = new S1143();
        int i = s1143.longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }
}

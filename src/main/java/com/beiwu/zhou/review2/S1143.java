package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-21 12:06
 */
public class S1143 {

    public int longestCommonSubsequence(String text1, String text2) {

        int text1Length = text1.length();
        int text2Length = text2.length();

        int[][] lcs = new int[text1Length + 1][text2Length + 1];

        for (int i = 1; i <= text1Length; i++) {
            for (int j = 1; j <= text2Length; j++) {
                // i代表行 j代表列
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 如果两位置的相等 那比较前方的
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    // 如果不相等 就看两个那个大
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        return lcs[text1Length][text2Length];

    }

    public static void main(String[] args) {
        S1143 s1143 = new S1143();
        int i = s1143.longestCommonSubsequence("ace", "abcde");
        System.out.println(i);
    }


}

package com.beiwu.zhou.review1;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-04-08 10:38
 */
public class S455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int fitNumber = 0;

        int gIndex = 0;
        int sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                fitNumber++;
                gIndex++;
                sIndex++;
            } else {
                sIndex++;
            }
        }
        return fitNumber;

    }

    public static void main(String[] args) {

    }
}

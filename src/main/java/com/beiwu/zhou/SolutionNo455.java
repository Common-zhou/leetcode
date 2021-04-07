package com.beiwu.zhou;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-04-07 11:34
 */
public class SolutionNo455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        // g是小孩的胃口
        int fitChildren = 0;
        int x = 0;
        int y = 0;
        while (x < g.length && y < s.length) {
            // 同步向后搜索
            if (g[x] <= s[y]) {
                // 满足 同时往后挪
                x++;
                y++;
                fitChildren++;
            } else {
                y++;
            }
        }
        return fitChildren;
    }

    public static void main(String[] args) {

    }
}

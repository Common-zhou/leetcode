package com.beiwu.zhou;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 1. 暴力法
 *
 * @author zhoubing
 * @date 2021-03-22 18:05
 */
public class SolutionNo84 {

    /**
     * 暴力法
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        int largestArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(heights[j], min);
                largestArea = Math.max(largestArea, (j - i + 1) * min);
            }
        }


        return largestArea;
    }

    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        return 0;
    }

    public static void main(String[] args) {
        SolutionNo84 solution = new SolutionNo84();
        System.out.println(solution.largestRectangleArea1(new int[] {0, 9}));
    }
}

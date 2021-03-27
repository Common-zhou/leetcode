package com.beiwu.zhou.no0_100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

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

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }


    public int largestRectangleAreaStack(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        Deque<Integer> stack = new LinkedList<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            // 代表i列
            int curHeight = heights[i];

            // 当栈不为空 并且栈顶的高度高于当前高度 代表有一批点已经有结果了
            while (!stack.isEmpty() && curHeight < heights[stack.peekLast()]) {
                Integer indexOfLast = stack.pollLast();

                // 取出所有相当的
                while (!stack.isEmpty() && heights[indexOfLast] == heights[stack.peekLast()]) {
                    stack.pollLast();
                }

                int curWidth = 0;
                // 现在就要算面积了
                if (stack.isEmpty()) {
                    // 栈为空 代表所有元素都出栈了  所以当前
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }
                max = Math.max(max, heights[indexOfLast] * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];

            // 取出所有相当的
            while (!stack.isEmpty() && curHeight == heights[stack.peekLast()]) {
                stack.pollLast();
            }

            int curWidth = 0;
            // 现在就要算面积了
            if (stack.isEmpty()) {
                // 栈为空 代表所有元素都出栈了  所以当前
                curWidth = heights.length;
            } else {
                curWidth = heights.length - stack.peekLast() - 1;
            }
            max = Math.max(max, curHeight * curWidth);
        }


        return max;
    }

    /**
     * 暴力法  这太暴力了
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
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

    public int largestRectangleArea3(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int left = i;
            int right = i;
            // 向左扩散 直到找到比h小的数
            while (left > 0) {
                if (h <= heights[left - 1]) {
                    left--;
                } else {
                    break;
                }
            }
            // 向右扩散 直到找到比h小的数
            while (right < heights.length - 1) {
                if (h <= heights[right + 1]) {
                    right++;
                } else {
                    break;
                }
            }
            max = Math.max(max, (right - left + 1) * h);
        }

        return max;
    }

    public static void main(String[] args) {
        SolutionNo84 solution = new SolutionNo84();
        System.out.println(solution.largestRectangleAreaStack(new int[] {2,1,5,6,2,3}));
    }
}

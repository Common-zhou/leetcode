package com.beiwu.zhou.review1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * @author zhoubing
 * @date 2021-03-24 22:40
 */
public class S84 {


    /**
     * 暴力法 遍历宽
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                // 要找到从i 到j的最小值
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    min = Math.min(min, heights[k]);
                }
                int area = min * (j - i + 1);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    /**
     * 暴力法  枚举高
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            // 这是第i列的高度 向左寻找 直到比它矮
            int h = heights[i];
            int left = i;
            int right = i;
            while (left > 0 && heights[left - 1] >= h) {
                left--;
            }
            while (right < heights.length - 1 && heights[right + 1] >= h) {
                right++;
            }
            int area = (right - left + 1) * h;
            max = Math.max(max, area);
        }
        return max;
    }

    /**
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Deque<Integer> deque = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[i] < heights[deque.peekLast()]) {
                // 代表当前元素比栈顶元素小 弹栈
                Integer top = deque.pollLast();
                int curHeight = heights[top];
                while (!deque.isEmpty() && heights[top] == heights[deque.peekLast()]) {
                    deque.pollLast();
                }

                int curWidth;
                if (deque.isEmpty()) {
                    // 代表当前元素是最小的
                    curWidth = i;
                } else {
                    curWidth = i - deque.peekLast() - 1;
                }

                max = Math.max(curWidth * curHeight, max);
            }
            deque.offerLast(i);
        }

        while (!deque.isEmpty()) {
            // 如果栈不为空
            Integer top = deque.pollLast();
            int curWidth;
            if (deque.isEmpty()) {
                // 代表当前元素是最小的
                curWidth = heights.length;
            } else {
                curWidth = heights.length - deque.peekLast() - 1;
            }


            max = Math.max(heights[top] * curWidth, max);
        }

        return max;
    }


    public static void main(String[] args) {
        S84 s84 = new S84();
        int area = s84.largestRectangleArea3(new int[]{2, 4});
        System.out.println(area);
    }
}

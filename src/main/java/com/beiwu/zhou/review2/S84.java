package com.beiwu.zhou.review2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoubing
 * @date 2021-04-01 13:58
 */
public class S84 {

    /**
     * 暴力法  遍历宽
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                // 从i到i 首先找内部 高最矮的
                int min = heights[i];
                for (int k = i + 1; k <= j; k++) {
                    if (heights[k] < min) {
                        min = heights[k];
                    }
                }
                max = Math.max(max, min * (j - i + 1));
            }
        }

        return max;
    }


    public int largestRectangleArea2(int[] heights) {
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            // 向左寻找 找到比当前矮的
            int left = i;
            int right = i;

            while (left > 0 && heights[i] <= heights[left - 1]) {
                left--;
            }

            // 向右寻找 找到比它矮的

            while (right < heights.length - 1 && heights[i] <= heights[right + 1]) {
                right++;
            }
            max = Math.max((right - left + 1) * heights[i], max);
        }


        return max;
    }


    /**
     * 单调栈
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        int max = 0;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < heights.length; i++) {
            // 如果进栈的元素 比栈尾的元素矮 说明什么？ 说明以该元素为高的矩形面积可以确定
            while (!deque.isEmpty() && heights[deque.peekLast()] > heights[i]) {
                Integer lastIndex = deque.pollLast();
                while (!deque.isEmpty() && heights[deque.peekLast()] == heights[lastIndex]) {
                    lastIndex = deque.pollLast();
                }

                int curWidth;
                // 如果当前栈为空
                // 说明什么？ 说明下一个元素比当前小 但是之前的全部都比当前元素大
                // 计算宽度 是从 i位置
                //
                // 如果不为空 说明什么？
                // 说明栈尾得元素比当前元素小 不能算
                if (deque.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - deque.peekLast() - 1;
                }

                max = Math.max(max, curWidth * heights[lastIndex]);
            }
            deque.addLast(i);
        }


        while (!deque.isEmpty()) {
            // 如果栈不为空 说明什么？ 说明在栈中元素
            Integer lastIndex = deque.pollLast();

            while (!deque.isEmpty() && heights[deque.peekLast()] == heights[lastIndex]) {
                lastIndex = deque.pollLast();
            }

            int curWidth;
            if (deque.isEmpty()) {
                curWidth = heights.length;
            } else {
                curWidth = heights.length - deque.peekLast() - 1;
            }
            max = Math.max(max, curWidth * heights[lastIndex]);
        }
        return max;

    }


    public static void main(String[] args) {
        S84 s84 = new S84();
        int max = s84.largestRectangleArea3(new int[] {2, 1, 5, 6, 2, 3});
        System.out.println(max);
    }
}

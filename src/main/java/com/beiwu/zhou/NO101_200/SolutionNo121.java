package com.beiwu.zhou.NO101_200;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoubing
 * @date 2021-04-23 16:22
 */
public class SolutionNo121 {
    /**
     * 暴力法  O(n^2)
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {

        int max = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }

        return max;

    }

    /**
     * 单调栈  如果当前的 更小
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(prices[0]);

        for (int i = 1; i < prices.length; i++) {
            if (!deque.isEmpty() && prices[i] <= deque.peekLast()) {
                // 如果进来的比栈尾的小 那就要不断弾栈
                while (!deque.isEmpty() && prices[i] <= deque.peekLast()) {
                    Integer last = deque.pollLast();
                    if (!deque.isEmpty()) {
                        // 栈不为空
                        max = Math.max(last - deque.peekFirst(), max);
                    }
                }
            }
            deque.addLast(prices[i]);
        }

        while (!deque.isEmpty()) {
            Integer last = deque.pollLast();
            if (!deque.isEmpty()) {
                // 栈不为空
                max = Math.max(last - deque.peekFirst(), max);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        SolutionNo121 solution = new SolutionNo121();
        int i = solution.maxProfit2(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }


}

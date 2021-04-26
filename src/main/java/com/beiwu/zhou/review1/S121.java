package com.beiwu.zhou.review1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoubing
 * @date 2021-04-26 10:49
 */
public class S121 {
    //[7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        Deque<Integer> deque = new LinkedList<>();
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            if (!deque.isEmpty() && prices[i] < deque.peekLast()) {
                while (!deque.isEmpty() && prices[i] <= deque.peekLast()) {
                    Integer last = deque.pollLast();
                    if (!deque.isEmpty()) {
                        max = Math.max(last - deque.peekFirst(), max);
                    }
                }
            }
            deque.addLast(prices[i]);
        }
        // 现在栈里面的是单调递增的
        max = Math.max(deque.peekLast() - deque.peekFirst(), max);
        return max;
    }

    public static void main(String[] args) {
        S121 s121 = new S121();
        int profit = s121.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(profit);
    }

}

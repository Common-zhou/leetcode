package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-08 10:31
 */
public class S122 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                // 后一天的大 可以考虑买了立马卖
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {

    }
}

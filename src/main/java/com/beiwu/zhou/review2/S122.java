package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-20 23:53
 */
public class S122 {

    /**
     * 如果判断后一天的股价大于当天的 那么可以买一手卖一手
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int max = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                max += (prices[i + 1] - prices[i]);
            }
        }
        return max;
    }
}

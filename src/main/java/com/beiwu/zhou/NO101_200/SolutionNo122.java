package com.beiwu.zhou.NO101_200;

/**
 * @author zhoubing
 * @date 2021-04-07 11:23
 */
public class SolutionNo122 {

    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                // 当第二天大于头一天 可以买
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        SolutionNo122 solution = new SolutionNo122();
        int maxProfit = solution.maxProfit(new int[] {7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
    }
}

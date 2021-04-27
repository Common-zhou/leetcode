package com.beiwu.zhou.review2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoubing
 * @date 2021-04-27 23:41
 */
public class S322 {

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        return helper(coins, amount, new HashMap<>());
    }

    public int helper(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int min = -1;
        for (int coin : coins) {
            int coinNumber = helper(coins, amount - coin, map);
            if (coinNumber != -1) {
                min = min == -1 ? coinNumber : Math.min(coinNumber, min);
            }
        }
        if (min != -1) {
            // 说明有得换
            map.put(amount, min + 1);
        } else {
            // 没找到
            map.put(amount, -1);
        }
        return map.get(amount);
    }

    public static void main(String[] args) {
        S322 s322 = new S322();
        int i = s322.coinChange(new int[] {1, 2, 5}, 11);
        System.out.println(i);
    }
}

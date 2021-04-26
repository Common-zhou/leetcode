package com.beiwu.zhou.review1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoubing
 * @date 2021-04-23 15:21
 */
public class S322 {
    public int coinChange(int[] coins, int amount) {
        int helper = helper(coins, amount, new HashMap<>());
        return helper;
    }

    public int helper(int[] coins, int amount, Map<Integer, Integer> map) {
        // 加入记忆化  map存储的 key是amount value是最少次数
        // 如果是Integer.MAX_VALUE 那就代表无法换
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
        for (int i = 0; i < coins.length; i++) {
            int result = helper(coins, amount - coins[i], map);
            if (result != -1) {
                if (min == -1) {
                    min = result;
                } else {
                    min = Math.min(result, min);
                }
            }

        }
        // 如果
        min = min == -1 ? min : min + 1;
        map.put(amount, min);
        return min;

    }

    public static void main(String[] args) {
        S322 s322 = new S322();
        //System.out.println(s322.coinChange(new int[]{1, 2, 5}, 100));
        System.out.println(s322.coinChange(new int[]{2}, 3));
    }


}

package com.beiwu.zhou;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zhoubing
 * @date 2021-04-20 17:00
 */
public class SolutionNo322 {

    /**
     * 用bfs的方法做
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(amount);

        int level = 0;

        while (!deque.isEmpty()) {
            level++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int money = deque.pollFirst();
                for (int coin : coins) {
                    if (money == coin) {
                        return level;
                    } else if (money > coin) {
                        deque.addLast(money - coin);
                    }
                }
            }
        }
        return -1;

    }

    /**
     * dp解决 100
     * 要不选1  要不选2  要不选5
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {

        return dp(coins, amount, new HashMap<>());
    }

    private int dp(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        if (map.containsKey(amount)){
            // 如果记忆了
            return map.get(amount);
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int coinChangeNumber = dp(coins, amount - coin, map);
            if (coinChangeNumber >= 0) {
                min = Math.min(coinChangeNumber + 1, min);
            }
        }
        if (min != Integer.MAX_VALUE) {
            map.put(amount, min);
        } else {
            map.put(amount, -1);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        SolutionNo322 solution = new SolutionNo322();

        int i = solution.coinChange2(new int[]{1, 2, 5}, 100);
        System.out.println(i);
    }


}

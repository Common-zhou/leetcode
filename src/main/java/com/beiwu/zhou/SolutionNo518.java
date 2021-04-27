package com.beiwu.zhou;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author zhoubing
 * @date 2021-04-24 00:34
 */
public class SolutionNo518 {

    public int change(int amount, int[] coins) {
        HashSet<List<Integer>> res = new HashSet<>();
        dfs(amount, coins, new LinkedList<>(), res);

        return res.size();
    }

    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public void dfs(int amount, int[] coins, Deque<Integer> select, Set<List<Integer>> res) {
        if (amount == 0) {
            ArrayList<Integer> list = new ArrayList<>(select);
            list.sort(Integer::compareTo);
            res.add(list);

            return;
        }

        if (amount < 0) {
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            select.addLast(coins[i]);
            dfs(amount - coins[i], coins, select, res);
            select.removeLast();
        }
    }

    public static void main(String[] args) {
        SolutionNo518 solution = new SolutionNo518();
        int change = solution.change(3, new int[] {3});
        System.out.println(change);
    }


}

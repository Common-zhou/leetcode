package com.beiwu.zhou.NO0_100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @author zhoubing
 * @date 2021-03-29 16:48
 */
public class SolutionNo77 {

    /**
     * 递归
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> choose = new LinkedList<>();

        combineRecurse(n, 1, res, choose, k);
        return res;
    }

    private void combineRecurse(int n, int leftIndex, List<List<Integer>> res,
                                Deque<Integer> choose, int k) {
        if (choose.size() == k) {
            res.add(new ArrayList<>(choose));
            return;
        }

        for (int i = leftIndex; i <= n; i++) {
            Integer integer = i;
            choose.addLast(integer);
            System.out.println("递归之前:" + choose.toString());
            combineRecurse(n, i + 1, res, choose, k);

            choose.removeLast();
        }

    }


    public static void main(String[] args) {
        SolutionNo77 solution = new SolutionNo77();
        List<List<Integer>> combine = solution.combine(6, 3);

        for (List<Integer> list : combine) {
            System.out.println(list);
        }
    }
}

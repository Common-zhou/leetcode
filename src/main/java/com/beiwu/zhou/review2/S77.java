package com.beiwu.zhou.review2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @author zhoubing
 * @date 2021-04-06 14:43
 */
public class S77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        combine(n, 1, k, deque, res);
        return res;
    }

    private void combine(int n, int i, int max, Deque<Integer> deque, List<List<Integer>> res) {
        if (deque.size() == max) {
            // 达成目标
            res.add(new ArrayList<>(deque));
            return;
        }

        // 现在走到了i 从i到n
        for (int j = i; j <= n; j++) {
            deque.addLast(j);
            combine(n, j + 1, max, deque, res);
            deque.removeLast();
        }

    }

    public static void main(String[] args) {
        S77 s77 = new S77();
        List<List<Integer>> lists = s77.combine(4, 2);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

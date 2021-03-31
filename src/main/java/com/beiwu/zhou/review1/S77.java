package com.beiwu.zhou.review1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-31 17:44
 */
public class S77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();

        backstrack(n, k, 1, new LinkedList<>(), res);
        return res;
    }

    private void backstrack(int n, int k, int selectedIndex, Deque<Integer> deque,
                            List<List<Integer>> res) {
        System.out.println("进入循环" + deque);
        if (deque.size() == k) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = selectedIndex; i <= n; i++) {
            deque.addLast(i);
            backstrack(n, k, i + 1, deque, res);
            deque.removeLast();
        }
    }


    public static void main(String[] args) {
        S77 s77 = new S77();
        List<List<Integer>> combine = s77.combine(4, 2);
        for (List<Integer> list : combine) {
            System.out.println(list);
        }
    }
}

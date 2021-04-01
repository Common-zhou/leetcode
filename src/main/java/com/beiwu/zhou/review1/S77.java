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

        // n个数 选k个  组合
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> selected = new LinkedList<>();
        backstrack(n, k, 1, selected, res);

        return res;
    }

    private void backstrack(int n, int k, int index, Deque<Integer> selected,
                            List<List<Integer>> res) {
        // terminal
        if (selected.size() == k) {
            res.add(new ArrayList<>(selected));
            return;
        }

        //process data
        for (int i = index; i <= n; i++) {
            selected.addLast(i);
            backstrack(n, k, i + 1, selected, res);
            selected.removeLast();
        }

        //drill down

        // reverse data
    }

    public static void main(String[] args) {
        S77 s77 = new S77();
        List<List<Integer>> combine = s77.combine(3, 2);
        for (List<Integer> list : combine) {
            System.out.println(list);
        }
    }
}

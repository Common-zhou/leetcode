package com.beiwu.zhou.review1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author zhoubing
 * @date 2021-04-06 16:14
 */
public class S51 {

    public List<List<String>> solveNQueens(int n) {
        Set<Integer> lie = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();

        List<List<Integer>> res = new ArrayList<>();
        recurse(n, 1, new LinkedList<>(), lie, pie, na, res);


        return print(res);
    }

    public List<List<String>> print(List<List<Integer>> res){
        List<List<String>> result = new ArrayList<>();

        for (List<Integer> list : res) {
            int len = list.size();
            List<String> one = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Integer index = list.get(i);
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j <= len; j++) {
                    if (index == j){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                one.add(sb.toString());
            }
            result.add(one);
        }
        return result;
    }

    public void recurse(int n, int currentHang,
                        Deque<Integer> select,
                        Set<Integer> lie, Set<Integer> pie,
                        Set<Integer> na, List<List<Integer>> res) {
        if (currentHang > n) {
            // 代表都搞定了
            res.add(new ArrayList<>(select));
            return;
        }

        // process data
        for (int i = 1; i <= n; i++) {
            if (lie.contains(i)) {
                // 如果 列已经被占了 只能继续
                continue;
            }

            int currentPie = currentHang + i;
            int currentNa = currentHang - i;
            if (pie.contains(currentPie) || na.contains(currentNa)) {
                continue;
            }

            lie.add(i);
            pie.add(currentPie);
            na.add(currentNa);

            select.addLast(i);
            // drill down
            recurse(n, currentHang + 1, select, lie, pie, na, res);

            // reverse data

            select.removeLast();
            lie.remove(i);
            pie.remove(currentPie);
            na.remove(currentNa);

        }

        // drill down

        // reverse data

    }


    public static void main(String[] args) {
        S51 s51 = new S51();
        List<List<String>> lists = s51.solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

}

package com.beiwu.zhou.review2;

import java.util.*;

/**
 * @author zhoubing
 * @date 2021-04-11 15:40
 */
public class S51 {

    public List<List<String>> solveNQueens(int n) {
        Deque<Integer> queens = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        dfs(n, queens, 0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), res);

        List<List<String>> queensComplate = printQueen(res);

        return queensComplate;

    }

    private List<List<String>> printQueen(List<List<Integer>> res) {
        List<List<String>> stringRes = new ArrayList<>();

        if (res == null || res.size() == 0){
            return stringRes;
        }

        int n = res.get(0).size();
        for (List<Integer> re : res) {
            List<String> str = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < re.get(i); j++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int j = re.get(i) + 1; j < n; j++) {
                    sb.append(".");
                }
                str.add(sb.toString());
            }
            stringRes.add(str);
        }

        return stringRes;
    }

    private void dfs(int rowNumber, Deque<Integer> queens, int row, Set<Integer> lie,
                     Set<Integer> pie, Set<Integer> na,
                     List<List<Integer>> res) {
        if (rowNumber == row) {
            // 结束了  退出
            res.add(new ArrayList<Integer>(queens));
            return;
        }
        for (int i = 0; i < rowNumber; i++) {
            if (lie.contains(i) || pie.contains(i + row) || na.contains(i - row)) {
                continue;
            }
            lie.add(i);
            pie.add(i + row);
            na.add(i - row);
            queens.addLast(i);
            dfs(rowNumber, queens, row + 1, lie, pie, na, res);

            lie.remove(i);
            pie.remove(i + row);
            na.remove(i - row);
            queens.removeLast();
        }

    }

    public static void main(String[] args) {
        S51 s51 = new S51();
        List<List<String>> lists = s51.solveNQueens(2);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}

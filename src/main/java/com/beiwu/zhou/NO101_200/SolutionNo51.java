package com.beiwu.zhou.NO101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhoubing
 * @date 2021-04-02 14:08
 */
public class SolutionNo51 {
    public List<List<String>> solveNQueens(int n) {

        Set<Integer> lie = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();

        // n皇后
        int[] queens = new int[n];

        List<int[]> res = new ArrayList<>();
        backstrack(queens, n, 0, lie, pie, na, res);

        List<List<String>> result = new ArrayList<>();
        for (int[] re : res) {
            result.add(convertToQ(re));
        }

        return result;
    }

    private List<String> convertToQ(int[] re) {
        List<String> queen = new ArrayList<>();
        int length = re.length;

        for (int i = 0; i < length; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < re[i]; j++) {
                line.append(".");
            }
            line.append("Q");
            for (int j = re[i] + 1; j < length; j++) {
                line.append(".");
            }
            queen.add(line.toString());
        }


        return queen;
    }

    private void backstrack(int[] queens, int n, int index,
                            Set<Integer> lie, Set<Integer> pie,
                            Set<Integer> na, List<int[]> res) {
        // terminal
        if (index == n) {
            // 代表插入成功
            res.add(Arrays.copyOf(queens, queens.length));
            return;
        }

        // process data
        for (int i = 0; i < n; i++) {
            // 代表这行 可以选那些列
            if (lie.contains(i) || pie.contains(i + index) || na.contains(i - index)) {
                // 说明之前存在  直接放弃
                continue;
            }

            lie.add(i);
            pie.add(i + index);
            na.add(i - index);

            queens[index] = i;

            backstrack(queens, n, index + 1, lie, pie, na, res);
            queens[index] = 0;

            lie.remove(i);
            pie.remove(i + index);
            na.remove(i - index);
        }

        // drill down

        // reverse data


    }


    public static void main(String[] args) {
        SolutionNo51 solution = new SolutionNo51();
        List<List<String>> lists = solution.solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}

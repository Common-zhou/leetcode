package com.beiwu.zhou.review2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-27 23:14
 */
public class S120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        // 从上往下

        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(0));

        for (int i = 1; i < triangle.size(); i++) {
            // 第i行 [1,lastIndex-1]
            // 如果i != 1 and i != lastIndex
            // dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j])+triangle[i][j]
            List<Integer> preDp = dp.get(i - 1);
            List<Integer> curDp = new ArrayList<>();

            List<Integer> curRow = triangle.get(i);

            curDp.add(preDp.get(0) + curRow.get(0));

            // 除了第一个和最后一个
            for (int j = 1; j < curRow.size() - 1; j++) {
                curDp.add(Math.min(preDp.get(j - 1), preDp.get(j)) + curRow.get(j));
            }

            curDp.add(preDp.get(curRow.size() - 2) + curRow.get(curRow.size() - 1));
            dp.add(curDp);
        }

        int min = Integer.MAX_VALUE;
        for (Integer val : dp.get(dp.size() - 1)) {
            min = Math.min(val, min);
        }
        return min;

    }

    public static void main(String[] args) {
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        S120 s120 = new S120();

        List<List<Integer>> parameter = new ArrayList<>();
        parameter.add(Arrays.asList(2));
        parameter.add(Arrays.asList(3, 4));
        parameter.add(Arrays.asList(6, 5, 7));
        parameter.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(s120.minimumTotal(parameter));
    }
}

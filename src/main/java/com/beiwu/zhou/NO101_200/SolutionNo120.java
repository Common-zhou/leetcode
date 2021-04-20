package com.beiwu.zhou.NO101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-20 11:29
 */
public class SolutionNo120 {

    /**
     * down - top
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // 如果当处于 x行 i列 那它只能选择下方的。
        for (int i = triangle.size() - 2; i >= 0; i--) {
            // 第i行
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                // 第j列
                int minValue = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, minValue);
            }
        }

        return triangle.get(0).get(0);
    }


    public int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();

        int[][] res = new int[len][len];
        res[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            // 从1到 len-1行
            // 第0列 和最后一列 只有一个加
            res[i][0] = res[i - 1][0] + triangle.get(i).get(0);
            List<Integer> list = triangle.get(i);

            int lastIndex = list.size() - 1;

            for (int j = 1; j < lastIndex; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            res[i][lastIndex] = res[i - 1][lastIndex - 1] + triangle.get(i).get(lastIndex);
        }

        int min = res[len - 1][0];
        for (int i = 1; i < res[len - 1].length; i++) {
            min = Math.min(min, res[len - 1][i]);
        }


        return min;
    }

    public static void main(String[] args) {
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3,4));
        input.add(Arrays.asList(6,5,7));
        input.add(Arrays.asList(4,1,8,3));

        SolutionNo120 solution = new SolutionNo120();
        int minimumTotal2 = solution.minimumTotal2(input);
        System.out.println(minimumTotal2);

    }
}

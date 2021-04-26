package com.beiwu.zhou.review1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-23 14:26
 */
public class S120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 从上往下走  每次只能走左侧 或者右侧
        // [1]
        // [2,3]
        List<Integer> path = new ArrayList<>(triangle.get(0).size());

        path.add(0, triangle.get(0).get(0));

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> integers = triangle.get(i);

            Integer leftNumber = path.get(0);
            Integer rightNumber = path.get(integers.size() - 2);

            List<Integer> newPath = new ArrayList<>(integers.size());

            newPath.add(integers.get(0) + leftNumber);

            for (int j = 1; j < integers.size() - 1; j++) {
                newPath.add(Math.min(path.get(j), path.get(j - 1)) + integers.get(j));
            }
            newPath.add(integers.get(integers.size() - 1) + rightNumber);
            path = newPath;
        }

        int min = path.get(0);
        for (int i = 1; i < path.size(); i++) {
            min = Math.min(min, path.get(i));
        }

        return min;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        // 从底向上
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> curLine = triangle.get(i);
            for (int j = 0; j < curLine.size(); j++) {
                curLine.set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + curLine.get(j));
            }
        }

        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        S120 s120 = new S120();

        List<List<Integer>> para = new ArrayList<>();
        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        para.add(Arrays.asList(2));
        para.add(Arrays.asList(3, 4));
        para.add(Arrays.asList(6, 5, 7));
        para.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(s120.minimumTotal2(para));
    }
}

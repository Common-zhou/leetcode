package com.beiwu.zhou.NO0_100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhoubing
 * @date 2021-05-18 17:30
 */
public class SolutionNo56 {

    public int[][] merge(int[][] intervals) {
        // 首先按照左端点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int[][] res = new int[intervals.length][];
        res[0] = intervals[0];

        int curIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前的值的左  大于结果里面的右 那直接塞入
            int[] curVal = intervals[i];
            int[] resVal = res[curIndex];

            if (curVal[0] > resVal[1]){
                curIndex++;
                res[curIndex] = curVal;
                continue;
            }

            // 否则将结果里面的右侧 取两者的最大
            resVal[1] = Math.max(curVal[1], resVal[1]);
        }

        int[][] totalRes = new int[curIndex+1][];
        for (int i = 0; i < curIndex + 1; i++) {
            totalRes[i] = res[i];
        }

        return totalRes;

    }

    public static void main(String[] args) {
        SolutionNo56 no56 = new SolutionNo56();
        //int[][] merge = no56.merge(new int[][]{{1, 4}, {4,5}});
        int[][] merge = no56.merge(new int[][]{{2, 6}, {1, 3}, {15, 18}, {8, 10},});

        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

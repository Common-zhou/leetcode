package com.beiwu.zhou.NO101_200;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-04-20 16:41
 */
public class SolutionNo152 {

    public int maxProduct(int[] nums) {
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];

        int totalMax = nums[0];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 有三个值 当前值 最大值*当前值 最小值*当前值
            int curVal = nums[i];
            int value1 = maxDp[i - 1] * curVal;
            int value2 = minDp[i - 1] * curVal;
            int[] ints = {curVal, value1, value2};
            Arrays.sort(ints);

            minDp[i] = ints[0];
            maxDp[i] = ints[2];
            totalMax = Math.max(ints[2], totalMax);
        }

        return totalMax;
    }

    public static void main(String[] args) {

    }
}

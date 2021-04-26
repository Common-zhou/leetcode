package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-23 15:05
 */
public class S152 {
    public int maxProduct(int[] nums) {
        int[] minValue = new int[nums.length];
        int[] maxValue = new int[nums.length];
        minValue[0] = nums[0];
        maxValue[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            minValue[i] = Math.min(Math.min(num * minValue[i - 1], num), Math.min(num * maxValue[i - 1], num));
            maxValue[i] = Math.max(Math.max(num * minValue[i - 1], num), Math.max(num * maxValue[i - 1], num));
        }

        int max = maxValue[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, maxValue[i]);
        }

        return max;

    }


}

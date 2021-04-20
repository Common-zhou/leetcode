package com.beiwu.zhou.NO0_100;

/**
 * @author zhoubing
 * @date 2021-04-20 12:18
 */
public class SolutionNo53 {

    public int maxSubArray(int[] nums) {
        int[] res = new int[nums.length];
        int max = nums[0];
        res[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int nowMax = Math.max(nums[i], res[i - 1] + nums[i]);
            res[i] = nowMax;
            max = Math.max(nowMax, max);
        }

        return max;

    }
}

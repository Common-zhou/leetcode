package com.beiwu.zhou.NO101_200;

/**
 * @author zhoubing
 * @date 2021-04-21 16:50
 */
public class SolutionNo198 {
    public int rob(int[] nums) {
        // 两个位置 头一个位置记录从头开始的最大的
        int[] dp = new int[nums.length];

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // 从i开始 i位置的最大值 有两种选择
            //      要么偷i位置+ dp(i-2)位置的
            //      要么不偷i位置的 + dp(i-1)位置的 比较两者哪个大
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];

    }

    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            // 当前位置的最大  有两种情况
            // 如果选了当前位置 那和为 nums[i] + dp(i-2)
            // 如果没有选当前位置 那和为 dp(i-1)
            // 取一个最大即可
            int tmp = Math.max(nums[i] + first, second);
            first = second;
            second = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        SolutionNo198 solution = new SolutionNo198();
        int rob = solution.rob2(new int[]{2, 7, 9, 3, 1});
        System.out.println(rob);
    }
}

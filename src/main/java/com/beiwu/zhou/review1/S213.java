package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-26 10:40
 */
public class S213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));

    }

    public int robRange(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < end - start + 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[start + i] + dp[i - 2]);
        }
        return dp[dp.length - 1];

    }

    public static void main(String[] args) {
        S213 s213 = new S213();
        int rob = s213.rob(new int[]{2, 3, 2});
        System.out.println(rob);
    }


}

package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-26 10:32
 */
public class S198 {
    /**
     * 房子有两种状态 要么偷 要么不偷
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

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
            // 第i个位置有两种状态 偷 、 不偷
            // dp方程存储的是到当前这个房子能偷的最大价值
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        S198 s198 = new S198();
        int rob = s198.rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }
}

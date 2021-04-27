package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-27 23:33
 */
public class S53 {
    public int maxSubArray(int[] nums) {
        //-2,1,-3,4,-1,2,1,-5,4
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;

    }

    public static void main(String[] args) {
        S53 s53 = new S53();
        int i = s53.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

}

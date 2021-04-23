package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-21 00:39
 */
public class S55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int maxReach = nums[0];

        // dp代表最远能到得到位置
        for (int i = 1; i < nums.length; i++) {
            if (maxReach < i) {
                // 说明无法到达
                return false;
            }
            maxReach = Math.max(maxReach, nums[i] + i);
        }
        return true;

    }
}

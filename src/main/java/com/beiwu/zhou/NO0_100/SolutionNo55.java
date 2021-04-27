package com.beiwu.zhou.NO0_100;

/**
 * @author zhoubing
 * @date 2021-04-24 14:07
 */
public class SolutionNo55 {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxReach < i) {
                // 到不了当前位置
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;

    }

    public static void main(String[] args) {
        SolutionNo55 solution = new SolutionNo55();
        boolean b = solution.canJump(new int[] {3, 2, 1, 0, 4});
        System.out.println(b);
    }

}

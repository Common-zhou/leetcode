package com.beiwu.zhou.NO201_300;

/**
 * @author zhoubing
 * @date 2021-04-21 18:13
 */
public class SolutionNo213 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 既然不能同时偷第一个和最后一个 那就分开偷 从[0,n-2] [1,n-1]
        // 这么偷
        return Math.max(robRange(nums, 0, nums.length - 2),
                robRange(nums, 1, nums.length - 1));

    }

    public int robRange(int[] nums, int start, int end) {
        // 从start偷到end
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start+2; i <= end; i++) {
            int tmp = Math.max(nums[i] + first, second);
            first = second;
            second = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        SolutionNo213 solution = new SolutionNo213();
        System.out.println(solution.rob(new int[]{2, 3, 2}));
    }
}

package com.beiwu.zhou.NO101_200;

/**
 * @author zhoubing
 * @date 2021-05-11 17:41
 */
public class SolutionNo162 {
    public int findPeakElement(int[] nums) {

        if (nums.length == 1) {
            // 只有1个 说明它就是峰值
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }


        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}

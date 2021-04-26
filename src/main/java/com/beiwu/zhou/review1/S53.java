package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-23 15:01
 */
public class S53 {
    public int maxSubArray(int[] nums) {
        int[] minValue = new int[nums.length];

        int max = nums[0];
        minValue[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            minValue[i] = Math.max(minValue[i-1]+nums[i], nums[i]);
            max = Math.max(max, minValue[i]);
        }
        return max;

    }


    public static void main(String[] args) {

    }
}

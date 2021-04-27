package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-27 23:36
 */
public class S152 {
    public int maxProduct(int[] nums) {
        int[] minVal = new int[nums.length];
        int[] maxVal = new int[nums.length];
        minVal[0] = nums[0];
        maxVal[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curNumber = nums[i];
            int num1 = curNumber * minVal[i - 1];
            int num2 = curNumber * maxVal[i - 1];

            minVal[i] = Math.min(Math.min(curNumber, num1), Math.min(curNumber, num2));
            maxVal[i] = Math.max(Math.max(curNumber, num1), Math.max(curNumber, num2));
        }
        int max = Integer.MIN_VALUE;
        for (int i : maxVal) {
            max = Math.max(max, i);
        }
        return max;

    }

    public static void main(String[] args) {
        S152 s152 = new S152();
        int i = s152.maxProduct(new int[] {2, 3, -2, 4});
        System.out.println(i);
    }
}

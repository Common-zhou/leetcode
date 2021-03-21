package com.beiwu.zhou;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-03-21 11:00
 */
public class SolutionNo189 {

    /**
     * 双数组
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        int[] newNums = Arrays.copyOf(nums, length);

        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = newNums[i];
        }

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        SolutionNo189 solution = new SolutionNo189();
        solution.rotate(nums, 3);

        System.out.println(Arrays.toString(nums));


        int[] newNums = {1, 2, 3, 4, 5};
        solution.reverse(newNums, 0, 3);
        System.out.println(Arrays.toString(newNums));

    }
}

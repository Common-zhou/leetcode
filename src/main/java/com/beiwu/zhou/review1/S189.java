package com.beiwu.zhou.review1;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-03-22 23:35
 */
public class S189 {

    /**
     * 直接copy一份 然后操作
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;

        int[] copyNums = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = copyNums[i];
        }

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);

        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }


    public static void main(String[] args) {
        S189 s189 = new S189();
        int[] nums = {1, 2, 3, 4, 5};
        s189.rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}

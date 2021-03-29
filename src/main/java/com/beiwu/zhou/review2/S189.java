package com.beiwu.zhou.review2;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-03-28 14:34
 */
public class S189 {

    /**
     * 复制一份
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int[] copyNums = Arrays.copyOf(nums, nums.length);

        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            // 把当前i位置的 往后挪动k个位置
            nums[(i + k) % length] = copyNums[i];
        }
    }

    /**
     * 将数组  按照指定下标 反转
     *
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
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
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        s189.rotate2(nums, 3);

        System.out.println(Arrays.toString(nums));
    }
}

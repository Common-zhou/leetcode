package com.beiwu.zhou.review2;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-03-27 20:20
 */
public class S283 {

    /**
     * 双指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int notZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZeroIndex] = nums[i];
                notZeroIndex++;
            }
        }

        while (notZeroIndex < nums.length) {
            nums[notZeroIndex++] = 0;
        }

    }

    public static void main(String[] args) {
        S283 s283 = new S283();
        int[] nums = {0, 1, 0, 3, 12};
        s283.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}

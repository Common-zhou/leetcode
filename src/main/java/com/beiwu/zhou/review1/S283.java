package com.beiwu.zhou.review1;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 1.用一个新数组
 * 2.两个指针
 *
 * @author zhoubing
 * @date 2021-03-21 16:12
 */
public class S283 {

    /**
     * 时间复杂度 O(2n) = O(n)
     * 空间复杂度 O(n)
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] newNums = Arrays.copyOf(nums, nums.length);

        int notZeroLength = 0;
        for (int i = 0; i < newNums.length; i++) {
            if (newNums[i] != 0) {
                nums[notZeroLength++] = newNums[i];
            }
        }

        for (int i = notZeroLength; i < newNums.length; i++) {
            nums[notZeroLength++] = 0;
        }

    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param nums
     */
    public void moveZeroes2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int notZeroLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZeroLength++] = nums[i];
            }
        }

        for (int i = notZeroLength; i < nums.length; i++) {
            nums[notZeroLength++] = 0;
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new S283().moveZeroes2(nums);

        System.out.println(Arrays.toString(nums));
    }
}

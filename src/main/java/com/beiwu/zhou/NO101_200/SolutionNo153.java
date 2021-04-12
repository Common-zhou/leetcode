package com.beiwu.zhou.NO101_200;

/**
 * @author zhoubing
 * @date 2021-04-09 11:02
 */
public class SolutionNo153 {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                // 说明右侧是递增的 往左侧找
                right = mid;
            } else {
                // 左侧是递增的
                left = mid + 1;
            }
        }

        return nums[right];
    }

    public static void main(String[] args) {

    }
}

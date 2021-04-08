package com.beiwu.zhou.NO0_100;

/**
 * @author zhoubing
 * @date 2021-04-08 17:08
 */
public class SolutionNo33 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 如果中间值相等 直接返回
                return mid;
            }
            if (nums[mid] < nums[right]) {
                //此时右侧有序
                if (target >= nums[mid] && target <= nums[right]) {
                    // 在右侧的范围内
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 左侧有序
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        SolutionNo33 solution = new SolutionNo33();
        int search = solution.search(new int[] {3,1}, 1);
        System.out.println(search);
    }
}

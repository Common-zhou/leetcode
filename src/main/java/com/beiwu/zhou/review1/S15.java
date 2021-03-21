package com.beiwu.zhou.review1;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * 1. 暴力法
 * 2. 双指针法
 *
 * @author zhoubing
 * @date 2021-03-21 17:01
 */
public class S15 {

    /**
     * 暴力法
     * 时间复杂度 O(n^3)
     * 空间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums, int sum) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == sum) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    //如果是等于0  就加到结果集
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(result);


    }

    public static void main(String[] args) {
        S15 s15 = new S15();
        List<List<Integer>> result = s15.threeSum1(new int[]{-1, 0, 1, 2, -1, -4}, 0);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }

        List<List<Integer>> result2 = s15.threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> integers : result2) {
            System.out.println(integers);
        }


    }
}

package com.beiwu.zhou;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 1.暴力解法
 * 2.hash表
 *
 * @author zhoubing
 * @date 2021-03-22 10:12
 */
public class SolutionNo1 {

    /**
     * 暴力解法
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }

        return new int[0];
    }

    /**
     * 用哈希表 key是值  value是坐标
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (valueToIndex.containsKey(target - nums[i])) {
                return new int[] {i, valueToIndex.get(target - nums[i])};
            } else {
                valueToIndex.put(nums[i], i);
            }
        }
        return new int[0];

    }


    public static void main(String[] args) {
        SolutionNo1 solution = new SolutionNo1();
        int[] ints = solution.twoSum2(new int[] {3, 2, 4}, 6);
        System.out.println(Arrays.toString(ints));
    }

}

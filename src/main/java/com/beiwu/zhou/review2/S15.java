package com.beiwu.zhou.review2;

import java.util.*;

/**
 * @author zhoubing
 * @date 2021-03-27 23:26
 */
public class S15 {

    /**
     * 暴力法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {

        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Integer[] ints = {nums[i], nums[j], nums[k]};
                        Arrays.sort(ints);
                        res.add(Arrays.asList(ints));
                    }
                }
            }
        }
        return new ArrayList<>(res);

    }

    /**
     * 采用左右指针
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {

        Set<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        S15 s15 = new S15();
        List<List<Integer>> list = s15.threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
}

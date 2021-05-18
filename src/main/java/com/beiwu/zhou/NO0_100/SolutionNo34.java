package com.beiwu.zhou.NO0_100;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-05-18 10:46
 */
public class SolutionNo34 {

    public int[] searchRange(int[] nums, int target) {
        // 最暴力的方法
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                end = i;
                break;
            }
        }

        return new int[]{start, end};
    }

    //public int[] searchRange2(int[] nums, int target) {
    //
    //}

    public static void main(String[] args) {
        SolutionNo34 no34 = new SolutionNo34();
        //int[] res = no34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 9);
        int[] res = no34.searchRange(new int[]{1}, 1);
        System.out.println(Arrays.toString(res));
    }

}

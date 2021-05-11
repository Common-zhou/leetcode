package com.beiwu.zhou.NO201_300;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-05-11 18:02
 */
public class SolutionNo238 {

    public int[] productExceptSelf(int[] nums) {
        // 存储一个左侧的积 一个右侧的积
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        right[right.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }

    public static void main(String[] args) {
        SolutionNo238 no238 = new SolutionNo238();
        int[] ints = no238.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }
}

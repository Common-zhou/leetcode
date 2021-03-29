package com.beiwu.zhou.review2;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-03-28 11:38
 */
public class S26 {


    /**
     * 暴力方法  用一个数组存储
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        int curLength = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[curLength] != nums[i]) {
                nums[++curLength] = nums[i];
            }
        }

        return curLength + 1;
    }


    public static void main(String[] args) {
        S26 s26 = new S26();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = s26.removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
}

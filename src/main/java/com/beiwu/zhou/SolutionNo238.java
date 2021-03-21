package com.beiwu.zhou;

import java.util.Arrays;

/**
 * 定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 1. 用一个新数组 遇到非零添上去 否则计数
 * 2. 记录下一个填充位置 然后往后移动
 *
 * @author zhoubing
 * @date 2021-03-20 00:34
 */
public class SolutionNo238 {

    public void moveZeroes(int[] nums) {
        //1. 记录下一个填充位置 然后往后移动

        int nextFill = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 不为0 填充到新的
                nums[nextFill++] = nums[i];
            }
        }

        for (int i = nextFill; i < nums.length; i++) {
            nums[i] = 0;
        }

        //System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes1(int[] nums) {
        //1. 用一个新数组 遇到非零添上去 否则计数
        int[] newNums = new int[nums.length];

        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 不为0 填充到新的
                newNums[size++] = nums[i];
            }
        }
        for (int i = size; i < nums.length; i++) {
            newNums[i] = 0;
        }
        System.out.println(Arrays.toString(newNums));

    }

    public static void main(String[] args) {
        new SolutionNo238().moveZeroes(new int[]{0,1,0,3,12});
    }
}

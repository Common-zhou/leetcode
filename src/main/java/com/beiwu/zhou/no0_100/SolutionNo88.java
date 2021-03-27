package com.beiwu.zhou.no0_100;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，
 * 这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 1.暴力法 直接复制一个 然后有序排列
 * 2.
 *
 * @author zhoubing
 * @date 2021-03-22 00:17
 */
public class SolutionNo88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1Copy = Arrays.copyOf(nums1, m);

        int nums1Index = 0;
        int nums2Index = 0;
        int index = 0;
        while (nums1Index < m && nums2Index < n) {
            // 都在索引范围内
            if (nums1Copy[nums1Index] <= nums2[nums2Index]) {
                nums1[index] = nums1Copy[nums1Index];
                nums1Index++;
            } else {
                nums1[index] = nums2[nums2Index];
                nums2Index++;
            }
            index++;
        }

        while (nums1Index < m){
            nums1[index] = nums1Copy[nums1Index];
            nums1Index++;
            index++;
        }

        while (nums2Index < n){
            nums1[index] = nums2[nums2Index];
            nums2Index++;
            index++;
        }

    }

    public static void main(String[] args) {
        //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        SolutionNo88 solutionNo88 = new SolutionNo88();

        //int[] nums1 = {1, 2, 3, 0, 0, 0};
        //int[] nums2 = {2, 5, 6};
        int[] nums1 = {1};
        int[] nums2 = {};
        solutionNo88.merge(nums1, 1, nums2, 0);

        System.out.println(Arrays.toString(nums1));
    }

}

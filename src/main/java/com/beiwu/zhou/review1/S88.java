package com.beiwu.zhou.review1;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * @author zhoubing
 * @date 2021-03-23 23:28
 */
public class S88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copyNums1 = Arrays.copyOf(nums1, nums1.length);

        int index1 = 0;
        int index2 = 0;
        int curLength = 0;

        while (index1 < m && index2 < n) {
            if (copyNums1[index1] <= nums2[index2]) {
                nums1[curLength++] = copyNums1[index1];
                index1++;
            } else {
                nums1[curLength++] = nums2[index2];
                index2++;
            }
        }

        while (index1 < m) {
            nums1[curLength++] = copyNums1[index1];
            index1++;
        }
        while (index2 < n) {
            nums1[curLength++] = nums2[index2];
            index2++;
        }


    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前遍历
        int curLength = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[curLength] = nums1[index1];
                index1--;
                curLength--;
            } else {
                nums1[curLength] = nums2[index2];
                index2--;
                curLength--;
            }
        }

        while (index1 >= 0) {
            nums1[curLength] = nums1[index1];
            index1--;
            curLength--;
        }
        while (index2 >= 0) {
            nums1[curLength] = nums2[index2];
            index2--;
            curLength--;
        }

    }

    public static void main(String[] args) {
        S88 s88 = new S88();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        s88.merge2(nums1, 3, new int[]{2, 5, 6}, 3);

        System.out.println(Arrays.toString(nums1));
    }
}

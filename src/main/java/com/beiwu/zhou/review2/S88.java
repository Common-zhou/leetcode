package com.beiwu.zhou.review2;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-03-29 17:24
 */
public class S88 {

    /**
     * 暴力法 复制一个
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copyNums1 = Arrays.copyOf(nums1, m);

        int num1Index = 0;
        int num2Index = 0;
        int index = 0;
        while (num1Index < m && num2Index < n) {
            // 如果都小于
            if (copyNums1[num1Index] <= nums2[num2Index]) {
                nums1[index++] = copyNums1[num1Index++];
            } else {
                nums1[index++] = nums2[num2Index++];
            }
        }

        while (num1Index < m) {
            nums1[index++] = copyNums1[num1Index++];
        }
        while (num2Index < n) {
            nums1[index++] = nums2[num2Index++];
        }

    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int index = m + n - 1;

        int num1Index = m - 1;
        int num2Index = n - 1;

        while (num1Index >= 0 && num2Index >= 0) {
            if (nums1[num1Index] >= nums2[num2Index]) {
                nums1[index] = nums1[num1Index];
                index--;
                num1Index--;
            } else {
                nums1[index] = nums2[num2Index];
                index--;
                num2Index--;
            }
        }

        while (num1Index >= 0) {
            nums1[index] = nums1[num1Index];
            index--;
            num1Index--;
        }
        while (num2Index >= 0) {
            nums1[index] = nums2[num2Index];
            index--;
            num2Index--;
        }

    }


    public static void main(String[] args) {
        S88 s88 = new S88();

        //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int[] nums1 = {0};
        s88.merge2(nums1, 0, new int[] {1}, 1);

        System.out.println(Arrays.toString(nums1));
    }
}

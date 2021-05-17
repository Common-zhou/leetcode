package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-05-17 22:43
 */
public class S162 {

    public int findPeakElement(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return nums.length - 1;
    }

    public static void main(String[] args) {
        S162 s162 = new S162();
        int peakElement = s162.findPeakElement(new int[] {1, 2, 1, 3, 5, 6, 4});
        int peakElement1 = s162.findPeakElement(new int[] {1, 2, 3, 1});
        System.out.println(peakElement);
        System.out.println(peakElement1);
    }

}

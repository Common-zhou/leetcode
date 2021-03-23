package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-03-22 23:27
 */
public class S26 {
    /**
     * 复制一个
     *
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int actualLength = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[actualLength] != nums[i]) {
                actualLength++;
                nums[actualLength] = nums[i];
            }
        }

        return actualLength+1;
    }


    public static void main(String[] args) {

    }
}

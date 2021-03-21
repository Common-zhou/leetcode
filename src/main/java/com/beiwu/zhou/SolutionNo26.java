package com.beiwu.zhou;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhoubing
 * @date 2021-03-21 10:27
 */
public class SolutionNo26 {
    public int removeDuplicates1(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        int actualLength = 0;

        for (int i = 0; i < nums.length; i++) {

            boolean isAddSuccess = set.add(nums[i]);
            if (isAddSuccess) {
                nums[actualLength++] = nums[i];
            }
        }

        return actualLength;
    }

    /**
     * 快慢指针  当前传入的nums已经有序
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int curLength = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[curLength] != nums[j]) {
                // 如果当前元素 不等于队尾元素 说明当前是一个新元素 将其添加到里面
                curLength++;
                nums[curLength] = nums[j];
            }
        }

        // 注意返回的是数组长度
        return curLength + 1;
    }

    public static void main(String[] args) {
        //int[] nums = {1,2,2,3,4,4,5,5,5,6,8,8,9,10,12,12,12,12};
        int[] nums = {1, 2, 2, 3, 4, 12, 12, 12, 12};
        int length = new SolutionNo26().removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }
}

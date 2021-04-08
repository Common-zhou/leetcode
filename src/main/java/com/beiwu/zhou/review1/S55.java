package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-08 16:27
 */
public class S55 {

    public boolean canJump(int[] nums) {
        int maxJump = 0;
        if (nums == null || nums.length == 0) {
            return false;
        }
        maxJump = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果maxJump小于了 说明不能跳到
            if (maxJump < i) {
                // 说明跳不到当前位置
                return false;
            }
            // 从第一个开始 如果maxJump大于当前的i  说明什么？ 说明可以跳到这里
            maxJump = Math.max(maxJump, nums[i] + i);
        }

        return true;
    }

    public static void main(String[] args) {

    }
}

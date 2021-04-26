package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-26 11:35
 */
public class S45 {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int end = nums[0];
        int step = 1;
        int maxPosition = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        S45 s45 = new S45();
        int jump = s45.jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump);
    }
}

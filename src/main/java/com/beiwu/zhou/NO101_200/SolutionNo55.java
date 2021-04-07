package com.beiwu.zhou.NO101_200;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author zhoubing
 * @date 2021-04-07 13:56
 */
public class SolutionNo55 {
    /**
     * nums = [2,3,1,1,4]
     * nums = [3,2,1,0,4]
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        // 把 index加进来
        Deque<Integer> deque = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        deque.addLast(0);

        visited.add(0);

        while (!deque.isEmpty()) {
            // 如果不为空 取出队头的
            Integer index = deque.pollFirst();
            if (index + nums[index] >= nums.length - 1) {
                // 说明可以到
                return true;
            }
            int num = nums[index];
            for (int i = 1; i <= num; i++) {
                if (!visited.contains(index + i)) {
                    deque.addLast(index + i);
                    visited.add(index + i);
                }
            }
        }

        return false;

    }


    public boolean canJump2(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }

        // 贪心法
        // 最远可以触达的地方
        int maxReach = 0;
        maxReach = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxReach < i) {
                // 不可触达当前位置
                return false;
            }
            maxReach = Math.max(maxReach, nums[i] + i);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        // nums = [2,3,1,1,4]
        // nums = [3,2,1,0,4]
        SolutionNo55 solution = new SolutionNo55();

        boolean res = solution.canJump(new int[] {1, 2, 3});
        System.out.println(res);
    }
}

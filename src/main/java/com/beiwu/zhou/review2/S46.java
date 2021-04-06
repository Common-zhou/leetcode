package com.beiwu.zhou.review2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-06 15:00
 */
public class S46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] choosed = new boolean[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        permute(nums, choosed, deque, res);

        return res;
    }

    private void permute(int[] nums, boolean[] choosed, Deque<Integer> deque,
                         List<List<Integer>> res) {
        if (deque.size() == nums.length) {
            // 全部取出  代表递归结束
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!choosed[i]) {
                // 如果没有被选
                choosed[i] = true;
                deque.addLast(nums[i]);
                permute(nums, choosed, deque, res);
                deque.removeLast();
                choosed[i] = false;
            }
        }
    }

    public static void main(String[] args) {

    }
}

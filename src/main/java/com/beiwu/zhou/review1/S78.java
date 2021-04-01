package com.beiwu.zhou.review1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-31 18:19
 */
public class S78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        backstrack(nums, 0, deque, res);
        return res;
    }

    private void backstrack(int[] nums, int index, Deque<Integer> deque, List<List<Integer>> res) {
        // terminal
        if (index == nums.length) {
            // 如果下标 超标了
            res.add(new ArrayList<>(deque));
            return;
        }

        // process data

        // 选当前层
        deque.addLast(nums[index]);
        backstrack(nums, index + 1, deque, res);
        deque.removeLast();

        backstrack(nums, index + 1, deque, res);

        //drill down

        // reverse data
    }


    public static void main(String[] args) {
        S78 s78 = new S78();
        List<List<Integer>> subsets = s78.subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }


}

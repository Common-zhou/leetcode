package com.beiwu.zhou.NO0_100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-30 16:08
 */
public class SolutionNo78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backstage(nums, new LinkedList<>(), 0, res);
        return res;
    }

    public void backstage(int[] nums, Deque<Integer> selected, int index, List<List<Integer>> res) {

        if (index == nums.length) {
            res.add(new ArrayList<>(selected));
            return;
        }

        backstage(nums, selected, index + 1, res);

        selected.addLast(nums[index]);
        backstage(nums, selected, index + 1, res);
        // 清除状态
        selected.removeLast();

    }


    public static void main(String[] args) {
        SolutionNo78 solution = new SolutionNo78();
        List<List<Integer>> subsets = solution.subsets(new int[] {1, 2, 3});
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}

package com.beiwu.zhou.NO0_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-30 10:08
 */
public class SolutionNo46 {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        LinkedList<Integer> parameter = new LinkedList<>();
        for (int num : nums) {
            parameter.add(num);
        }

        fullPermute(parameter, new LinkedList<>(), lists);

        return lists;
    }

    public void fullPermute(LinkedList<Integer> nums, Deque<Integer> select,
                            List<List<Integer>> res) {
        if (nums == null || nums.size() == 0) {
            res.add(new LinkedList<>(select));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            LinkedList<Integer> newList = new LinkedList<>(nums);
            newList.remove(nums.get(i));
            select.addLast(nums.get(i));
            fullPermute(newList, select, res);
            select.removeLast();
        }

    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        fullPermute2(nums, new boolean[nums.length], new LinkedList<>(), res);
        return res;
    }

    public void fullPermute2(int[] nums, boolean[] used,
                             Deque<Integer> selected, List<List<Integer>> res) {

        if (selected.size() == nums.length) {
            // 如果全部选中 则直接输出
            res.add(new ArrayList<>(selected));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                // 如果用过
                continue;
            }
            used[i] = true;
            selected.addLast(nums[i]);

            fullPermute2(nums, used, selected, res);
            //还原状态
            selected.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        SolutionNo46 solution = new SolutionNo46();
        List<List<Integer>> permute = solution.permute2(new int[] {1, 2, 3});
        for (List<Integer> list : permute) {
            System.out.println(list);
        }

        boolean[] booleans = new boolean[10];
        System.out.println(Arrays.toString(booleans));
    }
}

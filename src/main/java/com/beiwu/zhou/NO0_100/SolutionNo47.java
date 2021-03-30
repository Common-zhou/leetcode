package com.beiwu.zhou.NO0_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * @author zhoubing
 * @date 2021-03-30 10:49
 */
public class SolutionNo47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        fullPermute(nums, new boolean[nums.length], new LinkedList<>(), set);
        return new ArrayList<>(set);
    }

    public void fullPermute(int[] nums, boolean[] used, Deque<Integer> selected,
                            Set<List<Integer>> res) {
        if (selected.size() == nums.length) {
            res.add(new ArrayList<>(selected));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            selected.addLast(nums[i]);

            fullPermute(nums, used, selected, res);

            selected.removeLast();
            used[i] = false;
        }

    }


    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> set = new ArrayList<>();
        Arrays.sort(nums);
        fullPermute2(nums, new boolean[nums.length], new LinkedList<>(), set);
        return new ArrayList<>(set);
    }

    public void fullPermute2(int[] nums, boolean[] used, Deque<Integer> selected,
                             List<List<Integer>> res) {
        if (selected.size() == nums.length) {
            res.add(new ArrayList<>(selected));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                // 如果用过 或者是
                continue;
            }

            if (i > 0 && (nums[i - 1] == nums[i] && !used[i - 1])) {
                // 代表什么 ？ 代表它的上一个和它相等 但是上一个刚刚被撤销
                continue;
            }

            used[i] = true;
            selected.addLast(nums[i]);

            fullPermute2(nums, used, selected, res);

            selected.removeLast();
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        SolutionNo47 solution = new SolutionNo47();
        List<List<Integer>> lists = solution.permuteUnique2(new int[] {1, 2, 1});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

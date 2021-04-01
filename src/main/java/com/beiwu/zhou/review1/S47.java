package com.beiwu.zhou.review1;

import java.util.*;

/**
 * @author zhoubing
 * @date 2021-04-01 22:01
 */
public class S47 {

    public List<List<Integer>> permuteUnique1(int[] nums) {
        //// 首先排序
        //Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();
        boolean[] selected = new boolean[nums.length];
        // 将装的容器换成Set
        backstrack(nums, selected, deque, res);
        return new ArrayList<>(res);
    }

    private void backstrack(int[] nums, boolean[] selected, Deque<Integer> deque, Set<List<Integer>> res) {
        if (deque.size() == nums.length) {
            // 满了
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!selected[i]) {
                // 如果当前没有选
                deque.add(nums[i]);
                selected[i] = true;
                backstrack(nums, selected, deque, res);
                selected[i] = false;
                deque.removeLast();
            }
        }
    }


    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        boolean[] selected = new boolean[nums.length];
        // 首先排序
        Arrays.sort(nums);
        backstrack2(nums, selected, deque, res);

        return res;
    }

    private void backstrack2(int[] nums, boolean[] selected, Deque<Integer> deque, List<List<Integer>> res) {
        // terminal
        if (deque.size() == nums.length) {
            res.add(new ArrayList<>(deque));
            return;
        }

        // process data
        for (int i = 0; i < nums.length; i++) {
            if (selected[i]) {
                // 当前已经被选
                continue;
            }
            if (i > 0 && (nums[i - 1] == nums[i] && !selected[i - 1])) {
                // 代表当前元素和上一个元素相等 但是上一个元素没有被选择--> 代表它刚刚被撤销
                continue;
            }
            selected[i] = true;
            deque.addLast(nums[i]);
            backstrack2(nums, selected, deque, res);
            selected[i] = false;
            deque.removeLast();
        }

        // drill down

        // reverse data
    }


    public static void main(String[] args) {
        S47 s47 = new S47();
        List<List<Integer>> lists = s47.permuteUnique2(new int[]{1, 1, 2});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

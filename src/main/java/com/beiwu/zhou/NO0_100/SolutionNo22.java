package com.beiwu.zhou.NO0_100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author zhoubing
 * @date 2021-03-29 10:50
 */
public class SolutionNo22 {

    /**
     * 暴力法
     * 时间复杂度 O(n*2^n)
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        res = new ArrayList<>();
        generateAll(0, 2 * n, "");
        return res;
    }

    private void generateAll(int level, int max, String s) {
        if (level == max) {
            // 校验后打印
            if (isVaild(s)) {
                res.add(s);
            }
            return;
        }
        generateAll(level + 1, max, s + "(");
        generateAll(level + 1, max, s + ")");
    }

    private boolean isVaild(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.poll();
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        generate(0, 0, n, "");

        return res;
    }

    public void generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        // left 随时可以加  只要left小于n
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (left > right && right < n) {
            generate(left, right + 1, n, s + ")");
        }

    }

    public static void main(String[] args) {
        SolutionNo22 solution = new SolutionNo22();
        List<String> res = solution.generateParenthesis2(3);
        System.out.println(res);
    }
}

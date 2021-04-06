package com.beiwu.zhou.review2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-06 11:20
 */
public class S22 {

    /**
     * 全生成 之后校验
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate1(0, 2 * n, "", res);
        return res;
    }

    public boolean checkRigth(String str) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                deque.addLast(c);
            } else {
                // 如果不为空
                if (deque.isEmpty()) {
                    return false;
                }
                deque.removeLast();
            }
        }
        if (deque.isEmpty()) {
            return true;
        }
        return false;

    }

    public void generate1(int level, int max, String currentStr, List<String> res) {
        if (level == max) {
            if (checkRigth(currentStr)) {
                res.add(currentStr);
            }
            return;
        }
        generate1(level + 1, max, currentStr + "(", res);
        generate1(level + 1, max, currentStr + ")", res);
    }


    /**
     * 回溯调用 并传入left right
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        generate2(0, 0, n, "", res);
        return res;
    }

    private void generate2(int left, int right, int max, String currentStr, List<String> res) {
        if (left == max && right == max) {
            res.add(currentStr);
            return;
        }

        if (left < max) {
            generate2(left + 1, right, max, currentStr + "(", res);
        }
        if (right < left) {
            generate2(left, right + 1, max, currentStr + ")", res);
        }
    }


    public static void main(String[] args) {
        S22 s22 = new S22();
        List<String> strings = s22.generateParenthesis2(3);
        System.out.println(strings);
    }
}

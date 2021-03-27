package com.beiwu.zhou.no0_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author zhoubing
 * @date 2021-03-22 14:29
 */
public class SolutionNo20 {

    public boolean isLeftBracket(char flag) {
        return flag == '(' || flag == '[' || flag == '{';
    }

    public boolean isMatch(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        return false;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char charBracket = s.charAt(i);
            if (isLeftBracket(charBracket)) {
                stack.push(charBracket);
            } else {
                if (stack.isEmpty()) {
                    // 栈为空 说明不符合
                    return false;
                }
                Character leftBracket = stack.pop();
                if (!isMatch(leftBracket, charBracket)) {
                    // 如果校验失败
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }


    public boolean isValid2(String s) {

        if (s.length() % 2 != 0) {
            // 如果是奇数  那直接判断失败
            return false;
        }

        //Map<Character, Character> map = ImmutableMap
        //    .of('(', ')', '[', ']', '{', '}');
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsValue(ch)) {
                //是左括号
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    // 来了右括号 但是栈里是空的 匹配失败
                    return false;
                }
                if (map.get(ch) != stack.pop()) {
                    //括号不匹配
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        SolutionNo20 solution = new SolutionNo20();
        System.out.println(solution.isValid2("()[]{}"));
        System.out.println(solution.isValid2("()"));
        System.out.println(solution.isValid2("(}"));
    }
}

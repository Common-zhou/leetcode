package com.beiwu.zhou.review1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author zhoubing
 * @date 2021-03-24 00:28
 */
public class S20 {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsValue(chars[i])) {
                // 如果是左括号 压栈
                deque.addLast(chars[i]);
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                if (!map.get(chars[i]).equals(deque.pollLast())) {
                    return false;
                }
            }
        }

        if (deque.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        S20 s20 = new S20();

        System.out.println(s20.isValid("()"));
        System.out.println(s20.isValid("()[]{}"));
        System.out.println(s20.isValid("(]"));
    }
}

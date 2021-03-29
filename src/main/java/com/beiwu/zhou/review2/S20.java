package com.beiwu.zhou.review2;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zhoubing
 * @date 2021-03-29 18:11
 */
public class S20 {

    /**
     * 暴力法
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        while (true) {
            int length = s.length();
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            if (s.length() == length) {
                // 如果长度没变 说明失败了
                if (s.length() == 0) {
                    return true;
                }
                return false;
            }
        }
    }

    public boolean isValid2(String s) {
        // 用栈

        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> pair = new HashMap<>();
        pair.put('(', ')');
        pair.put('[', ']');
        pair.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pair.containsKey(ch)) {
                stack.addLast(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            } else {
                Character character = stack.removeLast();
                if(pair.get(character) != ch){
                    return false;
                }
            }
        }

        if (stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        S20 s20 = new S20();
        boolean valid = s20.isValid("(}");
        System.out.println(valid);

    }
}

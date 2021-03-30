package com.beiwu.zhou.NO0_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author zhoubing
 * @date 2021-03-30 12:02
 */
public class SolutionNo17 {

    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letterRecurse(res, "", digits, 0);
        return res;
    }

    private void letterRecurse(List<String> res, String curString, String digits,
                               int curLength) {
        if (curLength == digits.length()) {
            res.add(curString);
            return;
        }

        char currentChar = digits.charAt(curLength);
        String characters = map.get(currentChar);
        for (int i = 0; i < characters.length(); i++) {
            Character character = characters.charAt(i);
            letterRecurse(res, curString + character, digits, curLength + 1);
        }

    }


    public static void main(String[] args) {
        SolutionNo17 solution = new SolutionNo17();
        List<String> strings = solution.letterCombinations("234");
        System.out.println(strings);
    }
}

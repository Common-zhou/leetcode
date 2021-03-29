package com.beiwu.zhou.NO101_200;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zhoubing
 * @date 2021-03-25 23:20
 */
public class SolutionNo242 {

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                if ((map.get(c) - 1) >= 0) {
                    map.put(c, map.get(c) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;


    }

    public static void main(String[] args) {

    }
}

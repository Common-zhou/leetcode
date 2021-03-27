package com.beiwu.zhou.review1;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-03-27 17:31
 */
public class S242 {
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (Arrays.equals(chars1, chars2)) {
            return true;
        }

        return false;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphaCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            alphaCount[index] = alphaCount[index] + 1;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            alphaCount[index] = alphaCount[index] - 1;
        }

        for (int i = 0; i < alphaCount.length; i++) {
            if (alphaCount[i] != 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        S242 s242 = new S242();
        System.out.println(s242.isAnagram2("nl", "cx"));
    }
}

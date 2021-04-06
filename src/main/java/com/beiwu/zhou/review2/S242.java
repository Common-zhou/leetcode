package com.beiwu.zhou.review2;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * @author zhoubing
 * @date 2021-04-02 10:02
 */
public class S242 {

    public boolean isAnagram(String s, String t) {
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

    public static void main(String[] args) {
        S242 s242 = new S242();
        boolean anagram = s242.isAnagram("anagram", "nagaram");
        System.out.println(anagram);
    }
}

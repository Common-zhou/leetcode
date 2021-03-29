package com.beiwu.zhou.NO101_200;

import java.util.*;

/**
 * @author zhoubing
 * @date 2021-03-26 00:16
 */
public class SolutionNo49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] sortChars = str.toCharArray();
            Arrays.sort(sortChars);

            String sortStr = new String(sortChars);
            List<String> list = map.getOrDefault(sortStr, new ArrayList<>());
            list.add(str);
            map.put(sortStr, list);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;

    }


    public static void main(String[] args) {

    }
}

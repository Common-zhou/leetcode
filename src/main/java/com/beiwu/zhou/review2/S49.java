package com.beiwu.zhou.review2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhoubing
 * @date 2021-04-02 10:18
 */
public class S49 {
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sortKey = new String(chars);
            List<String> tmp = map.getOrDefault(sortKey, new ArrayList<>());
            tmp.add(str);
            map.put(sortKey, tmp);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

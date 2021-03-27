package com.beiwu.zhou.review1;

import java.util.*;

/**
 * @author zhoubing
 * @date 2021-03-27 17:21
 */
public class S49 {

    /**
     * 暴力法  采用map存储
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sortStr = new String(chars);
            List<String> strList = map.getOrDefault(sortStr, new ArrayList<>());
            strList.add(str);
            map.put(sortStr, strList);
        }

        list.addAll(map.values());

        return list;
    }

    public static void main(String[] args) {
        S49 s49 = new S49();
        List<List<String>> lists = s49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}

package com.beiwu.zhou.review2;

import java.util.*;

/**
 * @author zhoubing
 * @date 2021-04-13 13:04
 */
public class S433 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        //首先判断 末尾是否在bank中 如果不在 代表突变不会成功
        if (!bankSet.contains(end)) {
            return -1;
        }
        bankSet.remove(end);

        Deque<String> deque = new LinkedList<>();
        deque.addLast(start);

        String originStr = "AGCT";
        int level = 0;

        while (!deque.isEmpty()) {
            // 如果队列不为空 就继续取
            int size = deque.size();
            level++;

            for (int i = 0; i < size; i++) {
                // 这是代表第 n次变换的所有字符
                char[] chars = deque.pollFirst().toCharArray();

                // 对字符串的每一个字符 都可以变换
                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];

                    // 每一个字符 都可以转换为 AGCT
                    for (int k = 0; k < originStr.length(); k++) {
                        chars[j] = originStr.charAt(k);
                        String s = new String(chars);
                        if (end.equals(s)) {
                            return level;
                        } else if (bankSet.contains(s)) {
                            // 如果包含 就把它加入队列中 代表可以突变
                            deque.addLast(s);
                            // 并且删除bankSet的值
                            bankSet.remove(s);
                        }
                    }
                    chars[j] = oldChar;
                }
            }
        }


        return -1;
    }

}

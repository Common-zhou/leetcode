package com.beiwu.zhou.review2;

import java.util.*;

/**
 * @author zhoubing
 * @date 2021-04-13 13:54
 */
public class S127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            // 结尾不包含 直接拒绝
            return 0;
        }
        Deque<String> deque = new LinkedList<>();
        deque.addLast(beginWord);

        String possiableChar = "abcdefghijklmnopqrstuvwxyz";

        int level = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;

            for (int i = 0; i < size; i++) {
                // 这是代表 第n层的所有字符串
                char[] chars = deque.pollFirst().toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];

                    for (int k = 0; k < possiableChar.length(); k++) {
                        chars[j] = possiableChar.charAt(k);
                        String s = new String(chars);
                        if (endWord.equals(s)) {
                            return level + 1;
                        } else if (wordSet.contains(s)) {
                            wordSet.remove(s);
                            deque.addLast(s);
                        }
                    }
                    chars[j] = oldChar;
                }


            }
        }
        return 0;

    }

    public static void main(String[] args) {
        //"lost"
        //"miss"
        //["most","mist","miss","lost","fist","fish"]
        S127 s127 = new S127();
        int count = s127.ladderLength("lost", "miss", Arrays.asList("most", "mist", "miss", "lost", "fist", "fish"));
        System.out.println(count);
    }

}

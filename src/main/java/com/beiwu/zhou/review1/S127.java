package com.beiwu.zhou.review1;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * <p>
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，
 * 找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 *
 * @author zhoubing
 * @date 2021-04-07 15:38
 */
public class S127 {
    /**
     * 采用bfs方式
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            // 如果不包括 直接返回0
            return 0;
        }
        set.remove(endWord);

        Deque<String> deque = new LinkedList<>();
        deque.addLast(beginWord);

        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int level = 0;

        while (!deque.isEmpty()) {
            level++;
            // 进一层 取出这层的全部
            int size = deque.size();

            // 所有的情况
            for (int i = 0; i < size; i++) {
                char[] chars = deque.pollFirst().toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];
                    for (int k = 0; k < alpha.length(); k++) {
                        chars[j] = alpha.charAt(k);
                        String newStr = new String(chars);
                        if (endWord.equals(newStr)) {
                            return level;
                        } else if (set.contains(newStr)) {
                            // 如果中间包含 在字典中 可以将其加入队列中
                            deque.addLast(newStr);
                            set.remove(newStr);
                        }
                    }
                    chars[j] = oldChar;
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {

    }
}

package com.beiwu.zhou;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author zhoubing
 * @date 2021-04-06 17:04
 */
public class SolutionNo433 {

    /**
     * 写出思路
     * 首先 一次改变只改变一个字符
     * 其次 改变的必须在基因库中
     * 问几步可以变过去
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] four = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.remove(start);
        int step = 0;
        while (queue.size() > 0) {
            step++;
            for (int count = queue.size(); count > 0; --count) {
                char[] temStringChars = queue.poll().toCharArray();
                for (int i = 0, len = temStringChars.length; i < len; ++i) {
                    char oldChar = temStringChars[i];
                    for (int j = 0; j < 4; ++j) {
                        temStringChars[i] = four[j];
                        String newGenetic = new String(temStringChars);
                        if (end.equals(newGenetic)) {
                            return step;
                        } else if (set.contains(newGenetic)) {
                            set.remove(newGenetic);
                            queue.offer(newGenetic);
                        }
                    }
                    temStringChars[i] = oldChar;
                }
            }
        }
        return -1;
    }

    public int minMutation2(String start, String end, String[] bank) {

        // 1. 首先记录可以走的路  set
        Set<String> feasibleStr = new HashSet<>(Arrays.asList(bank));

        if (!feasibleStr.contains(end)) {
            // end不在可突变基因里 失败
            return -1;
        }

        // 2.对每一个都进行穷举  如果在set里面就代表这步突变有可能有用

        Deque<String> deque = new LinkedList<>();
        deque.addLast(start);

        Character[] basics = new Character[] {'A', 'G', 'C', 'T'};

        int step = 0;

        while (!deque.isEmpty()) {
            step++;

            // 如果队列不为空  当前size 一次遍历完  这是一个bfs过程
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                char[] chars = deque.pollFirst().toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];

                    for (int k = 0; k < basics.length; k++) {
                        // 将当前的改成 A G C T 四个 随意一个
                        chars[j] = basics[k];
                        String newStr = new String(chars);
                        if (end.equals(newStr)) {
                            // 找到了
                            return step;
                        } else if (feasibleStr.contains(newStr)) {
                            // 如果包含了 说明这步可行
                            deque.addLast(newStr);
                            // 把这个删掉 记录一下已经走过
                            feasibleStr.remove(newStr);
                        }
                    }
                    // 撤回去
                    chars[j] = oldChar;

                }

            }

        }

        return -1;
    }

    public static void main(String[] args) {
        SolutionNo433 solution = new SolutionNo433();
        int step = solution.minMutation2("AACCGGTT", "AAACGGTA",
            new String[] {"AACCGGTA", "AACCGCTA", "AAACGGTA"});
        System.out.println(step);
    }
}

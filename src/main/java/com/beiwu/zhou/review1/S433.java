package com.beiwu.zhou.review1;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * <p>
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * <p>
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * <p>
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，
 * 请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 * <p>
 * 注意：
 * <p>
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 *
 * @author zhoubing
 * @date 2021-04-07 15:49
 */
public class S433 {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));

        if (!set.contains(end)) {
            // 不包含  代表失败
            return -1;
        }

        String totalSeq = "AGCT";
        Deque<String> deque = new LinkedList<>();
        deque.addLast(start);

        int level = 0;
        while (!deque.isEmpty()) {
            level++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                char[] chars = deque.pollFirst().toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];
                    for (int k = 0; k < totalSeq.length(); k++) {
                        chars[j] = totalSeq.charAt(k);
                        String newStr = new String(chars);
                        if (end.equals(newStr)) {
                            return level;
                        } else if (set.contains(newStr)) {
                            // 如果
                            set.remove(newStr);
                            deque.addLast(newStr);
                        }
                    }
                    chars[j] = oldChar;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        S433 s433 = new S433();
        int i = s433.minMutation("AACCGGTT", "AACCGGTA", new String[] {"AACCGGTA"});
        System.out.println(i);
    }
}

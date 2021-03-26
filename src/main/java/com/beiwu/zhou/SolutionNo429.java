package com.beiwu.zhou;

import com.beiwu.zhou.utils.TreeNodeUtils;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-26 13:05
 */
public class SolutionNo429 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        traverseNode(root, 0);
        return result;
    }

    private void traverseNode(Node root, int level) {

        if (root == null) {
            return;
        }

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        if (root.children != null) {
            for (Node child : root.children) {
                traverseNode(child, level + 1);
            }
        }

    }


    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Node> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            // 如果queue不为空
            int size = deque.size();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                list.add(node.val);
                if (node.children != null) {
                    deque.addAll(node.children);
                }
            }

            // 代表一层处理完成
            res.add(list);
        }

        return res;

    }

    public static void main(String[] args) {
        Node node = TreeNodeUtils.createByArray(new Integer[] {1, null, 3, 2, 4, null, 5, 6});

        SolutionNo429 solution = new SolutionNo429();
        List<List<Integer>> lists = solution.levelOrder(node);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

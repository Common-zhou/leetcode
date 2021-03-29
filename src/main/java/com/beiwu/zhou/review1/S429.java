package com.beiwu.zhou.review1;

import com.beiwu.zhou.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-28 18:26
 */
public class S429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        recurseLevel(root, 0, res);

        return res;
    }


    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Deque<Node> queue = new LinkedList<>();

        queue.addLast(root);
        int level = 0;
        while (!queue.isEmpty()) {

            if (res.size() < level + 1) {
                res.add(new ArrayList<>());
            }
            List<Integer> resLevel = res.get(level);

            // 当栈不为空 那么一次取出这一层的
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.pollFirst();
                resLevel.add(node.val);
                //queue.addAll(node.children);
                for (Node child : node.children) {
                    queue.addLast(child);
                }
            }
            level++;

        }

        return res;
    }

    private void recurseLevel(Node root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        if (res.size() < level + 1) {
            res.add(level, new ArrayList<>());
        }

        List<Integer> levelRes = res.get(level);
        levelRes.add(root.val);
        res.set(level, levelRes);

        if (root.children != null) {
            for (Node node : root.children) {
                recurseLevel(node, level + 1, res);
            }
        }
    }

    public static void main(String[] args) {

    }
}

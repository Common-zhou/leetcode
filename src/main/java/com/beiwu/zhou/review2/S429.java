package com.beiwu.zhou.review2;

import com.beiwu.zhou.Node;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * @author zhoubing
 * @date 2021-04-02 11:26
 */
public class S429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = deque.pollFirst();
                levelRes.add(node.val);
                for (Node child : node.children) {
                    deque.addLast(child);
                }
            }
            res.add(levelRes);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}

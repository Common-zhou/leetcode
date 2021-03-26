package com.beiwu.zhou;

import com.beiwu.zhou.utils.TreeNodeUtils;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * @author zhoubing
 * @date 2021-03-26 12:21
 */
public class SolutionNo589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                res.addAll(preorder(node));
            }
        }
        return res;
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root == null){
            return res;
        }

        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            Node node = deque.pollLast();
            res.add(node.val);

            List<Node> children = node.children;
            if (children != null) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    deque.addLast(children.get(i));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Node node = TreeNodeUtils.createByArray(new Integer[] {1, null, 3, 2, 4, null, 5, 6});
        SolutionNo589 solution = new SolutionNo589();

        List<Integer> preorder = solution.preorder2(node);
        System.out.println(preorder);
    }

}

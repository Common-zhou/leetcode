package com.beiwu.zhou;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * @author zhoubing
 * @date 2021-03-26 11:50
 */
public class SolutionNo94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));

        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 中序遍历
        TreeNode node = root;
        Deque<TreeNode> deque = new LinkedList<>();

        while (!deque.isEmpty() || node != null) {
            // 先压栈 等到弹栈的时候 再读数
            while (node != null) {
                deque.addLast(node);
                node = node.left;
            }
            node = deque.pollLast();
            res.add(node.val);
            node = node.right;
        }

        return res;
    }

    public static void main(String[] args) {

        TreeNode no3 = new TreeNode(3);
        TreeNode no2 = new TreeNode(2, no3, null);

        TreeNode no1 = new TreeNode(1, null, no2);

        SolutionNo94 solution = new SolutionNo94();
        List<Integer> list = solution.inorderTraversal2(no1);
        System.out.println(list);


    }
}

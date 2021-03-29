package com.beiwu.zhou.NO101_200;

import com.beiwu.zhou.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * @author zhoubing
 * @date 2021-03-26 12:02
 */
public class SolutionNo144 {

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;

    }

    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            // 前序遍历
            while (root != null) {
                res.add(root.val);
                stack.addLast(root);
                root = root.left;
            }
            root = stack.removeLast();
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode no3 = new TreeNode(3);
        TreeNode no2 = new TreeNode(2, no3, null);

        TreeNode no1 = new TreeNode(1, null, no2);

        SolutionNo144 solution = new SolutionNo144();
        List<Integer> list = solution.preorderTraversal2(no1);
        System.out.println(list);
    }
}

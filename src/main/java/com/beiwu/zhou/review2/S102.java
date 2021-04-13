package com.beiwu.zhou.review2;

import com.beiwu.zhou.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 层序遍历
 *
 * @author zhoubing
 * @date 2021-04-13 12:47
 */
public class S102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> levelRes = new ArrayList<>();

            // 首先看一下当前队列还有多少
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                levelRes.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            res.add(levelRes);
        }
        return res;

    }

    public static void main(String[] args) {

    }
}

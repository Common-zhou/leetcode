package com.beiwu.zhou.review1;

import com.beiwu.zhou.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoubing
 * @date 2021-03-30 18:17
 */
public class S104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }
        return depth;

    }


    public static void main(String[] args) {

    }
}

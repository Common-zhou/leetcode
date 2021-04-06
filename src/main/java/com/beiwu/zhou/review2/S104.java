package com.beiwu.zhou.review2;

import com.beiwu.zhou.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoubing
 * @date 2021-04-06 14:03
 */
public class S104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {

        if (root == null){
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int level = 0;
        while (!deque.isEmpty()){
            Deque<TreeNode> tmp = new LinkedList<>();
            int size = deque.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (node.left != null){
                    tmp.addLast(node.left);
                }
                if (node.right != null){
                    tmp.addLast(node.right);
                }
            }
            deque = tmp;
        }

        return level;
    }

    public static void main(String[] args) {

    }
}

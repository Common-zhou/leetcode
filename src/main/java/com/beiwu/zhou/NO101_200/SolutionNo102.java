package com.beiwu.zhou.NO101_200;

import com.beiwu.zhou.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-06 16:57
 */
public class SolutionNo102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> levelRes = new ArrayList<>();
            // 如果双端队列不为空
            int size = deque.size();
            // 一次将一层全部拿出
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

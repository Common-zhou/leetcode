package com.beiwu.zhou.NO201_300;

import com.beiwu.zhou.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoubing
 * @date 2021-03-31 15:24
 */
public class SolutionNo236 {

    /**
     * 递归判断 所给的
     *
     * @return
     */
    public boolean reCheckExist(TreeNode root, TreeNode target) {
        if (root == null) {
            // 找到头了 不存在这个子树
            return false;
        }
        if (root == target) {
            return true;
        }
        return reCheckExist(root.left, target) || reCheckExist(root.right, target);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        TreeNode target = null;

        while (!deque.isEmpty()) {

            TreeNode node = deque.removeFirst();

            if (reCheckExist(node, p) && reCheckExist(node, q)) {
                // 如果都包含在这里
                target = node;
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }
        return target;
    }


    public static void main(String[] args) {


    }
}

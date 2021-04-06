package com.beiwu.zhou.review2;

import com.beiwu.zhou.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoubing
 * @date 2021-04-06 15:48
 */
public class S236 {
    /**
     * 检测一个node是否包含target
     *
     * @param node   子树
     * @param target 待寻找的节点
     * @return
     */
    public boolean recurCheck(TreeNode node, TreeNode target) {
        if (node == null) {
            // 找到最后了 不是
            return false;
        }
        if (node == target) {
            return true;
        }
        return recurCheck(node.left, target) || recurCheck(node.right, target);

    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode target = root;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            if (recurCheck(node, p) && recurCheck(node, q)) {
                // 如果发现当前节点满足 将其左右节点不为null的加入
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

    TreeNode ans;

    public S236() {
        this.ans = null;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        if ((lson && rson) || (root == p || root == q) && (lson || rson)) {
            ans = root;
        }
        return (lson && rson) || (root == p || root == q) && (lson || rson);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return ans;
    }


    public static void main(String[] args) {

    }
}

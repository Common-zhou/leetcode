package com.beiwu.zhou.review2;

import com.beiwu.zhou.TreeNode;

/**
 * @author zhoubing
 * @date 2021-04-06 15:48
 */
public class S236 {
    /**
     * 暴力查找
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            // 越过了叶子节点
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }


    public static void main(String[] args) {

    }
}

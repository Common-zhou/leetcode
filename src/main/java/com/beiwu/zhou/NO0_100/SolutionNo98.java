package com.beiwu.zhou.NO0_100;

import com.beiwu.zhou.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author zhoubing
 * @date 2021-03-29 11:44
 */
public class SolutionNo98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        if (root.left != null && root.val >= root.left.val) {
            return false;
        }
        if (root.right != null && root.val < root.right.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBST3(TreeNode root) {
        return isVaildBSTRecurse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isVaildBSTRecurse(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isVaildBSTRecurse(root.left, lower, root.val) &&
            isVaildBSTRecurse(root.right, root.val, upper);
    }


    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = inorderTraverse(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                // 当前序列不严格递增
                return false;
            }
        }
        return true;
    }

    public List<Integer> inorderTraverse(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraverse(root.left));
        res.add(root.val);
        res.addAll(inorderTraverse(root.right));
        return res;
    }


    public static void main(String[] args) {


    }
}

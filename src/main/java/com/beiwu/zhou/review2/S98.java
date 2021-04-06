package com.beiwu.zhou.review2;

import com.beiwu.zhou.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-06 11:41
 */
public class S98 {

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        // terminal
        if (root == null) {
            return true;
        }

        List<Integer> inorder = inorder(root);
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i - 1) >= inorder.get(i)) {
                return false;
            }
        }
        return true;

        // process data
        // drill down


        // reverse data

    }

    public List<Integer> inorder(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        res.addAll(inorder(node.left));
        res.add(node.val);
        res.addAll(inorder(node.right));
        return res;
    }


    public boolean isValidBST2(TreeNode root) {
        return isValidBSTRecurve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTRecurve(TreeNode root, long lower, long higher) {
        if (root == null) {
            return true;
        }

        if (root.val <= lower || root.val >= higher) {
            return false;
        }
        return isValidBSTRecurve(root.left, lower, root.val) &&
            isValidBSTRecurve(root.right, root.val, higher);
    }

    public static void main(String[] args) {

    }
}

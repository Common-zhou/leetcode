package com.beiwu.zhou.review2;

import com.beiwu.zhou.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-02 11:09
 */
public class S144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null){
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));

        return res;
    }

    public static void main(String[] args) {

    }
}

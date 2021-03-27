package com.beiwu.zhou.review1;

import com.beiwu.zhou.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-27 18:58
 */
public class S589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                res.addAll(preorder(node));
            }
        }

        return res;
    }


    public static void main(String[] args) {

    }
}

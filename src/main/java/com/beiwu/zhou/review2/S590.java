package com.beiwu.zhou.review2;

import com.beiwu.zhou.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-02 11:13
 */
public class S590 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        for (Node node : root.children) {
            res.addAll(postorder(node));
        }
        res.add(root.val);
        return res;
    }

    public static void main(String[] args) {

    }
}

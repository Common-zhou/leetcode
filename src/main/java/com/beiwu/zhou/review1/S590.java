package com.beiwu.zhou.review1;

import com.beiwu.zhou.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-27 18:58
 */
public class S590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        if (root.children != null){
            for (Node node : root.children) {
                res.addAll(postorder(node));
            }
        }
        res.add(root.val);
        return res;
    }


    public static void main(String[] args) {

    }
}

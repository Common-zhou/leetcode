package com.beiwu.zhou;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * @author zhoubing
 * @date 2021-03-26 12:21
 */
public class SolutionNo590 {


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

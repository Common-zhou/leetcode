package com.beiwu.zhou.review1;

import com.beiwu.zhou.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-31 15:03
 */
public class S297 {

    public String reserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = reserialize(root.left, str);
            str = reserialize(root.right, str);
        }

        return str;

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reserialize(root, "");
    }

    public TreeNode rdeserialize(List<String> data) {
        if (data.get(0).equals("None")) {
            data.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        root.left = rdeserialize(data);
        root.right = rdeserialize(data);

        return root;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return rdeserialize(list);
    }


    public static void main(String[] args) {

    }
}

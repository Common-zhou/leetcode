package com.beiwu.zhou.review1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-30 17:33
 */
public class S22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backstrack(0, 0, n, "", res);
        return res;
    }

    public void backstrack(int left, int right, int n, String bracket, List<String> res) {
        if (left == n && right == n) {
            res.add(bracket);
            return;
        }

        if (left < n) {
            backstrack(left + 1, right, n, bracket + "(", res);
        }
        if (left > right) {
            backstrack(left, right + 1, n, bracket + ")", res);
        }
    }


    public static void main(String[] args) {
        S22 s22 = new S22();
        List<String> strings = s22.generateParenthesis(3);
        System.out.println(strings);
    }
}

package com.beiwu.zhou.NO101_200;

import com.beiwu.zhou.ListNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhoubing
 * @date 2021-05-18 10:28
 */
public class SolutionNo142 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head!= null){
            if (visited.contains(head)){
                return head;
            }
            visited.add(head);
            head = head.next;
        }
        return null;

    }

    public static void main(String[] args) {

    }

}

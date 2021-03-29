package com.beiwu.zhou.review2;

import com.beiwu.zhou.ListNode;

/**
 * @author zhoubing
 * @date 2021-03-28 11:33
 */
public class S141 {
    public boolean hasCycle(ListNode head) {
        // 快慢指针

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {

    }
}

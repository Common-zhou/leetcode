package com.beiwu.zhou.review1;

import com.beiwu.zhou.LinkedListNodeUtils;
import com.beiwu.zhou.ListNode;

/**
 * @author zhoubing
 * @date 2021-03-22 23:54
 */
public class S21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode l1 = LinkedListNodeUtils.createLinkedList(new int[]{1, 2, 4});
        ListNode l2 = LinkedListNodeUtils.createLinkedList(new int[]{1, 3, 4});

        S21 s21 = new S21();
        ListNode head = s21.mergeTwoLists(l1, l2);
        LinkedListNodeUtils.printListNode(head);

    }
}

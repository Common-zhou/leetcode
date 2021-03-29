package com.beiwu.zhou.review2;

import com.beiwu.zhou.LinkedListNodeUtils;
import com.beiwu.zhou.ListNode;

/**
 * @author zhoubing
 * @date 2021-03-28 14:47
 */
public class S21 {

    /**
     * 采用递归实现
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val < l2.val) {
                ListNode next = mergeTwoLists(l1.next, l2);
                l1.next = next;
                return l1;
            } else {
                ListNode next = mergeTwoLists(l1, l2.next);
                l2.next = next;
                return l2;
            }
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            } else {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
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

package com.beiwu.zhou.no0_100;

import com.beiwu.zhou.LinkedListNodeUtils;
import com.beiwu.zhou.ListNode;

/**
 * @author zhoubing
 * @date 2021-03-21 12:08
 */
public class SolutionNo21 {

    /**
     * 递归写法
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
            if (l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }

    }


    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }

        cur.next = l1 != null ? l1 : l2;

        return head.next;
    }

    public static void main(String[] args) {
        ListNode linkedList1 = LinkedListNodeUtils.createLinkedList(new int[]{1, 2, 4});
        ListNode linkedList2 = LinkedListNodeUtils.createLinkedList(new int[]{1, 3, 4});


        ListNode mergeList = new SolutionNo21().mergeTwoLists(linkedList1, linkedList2);
        LinkedListNodeUtils.printListNode(mergeList);
    }
}

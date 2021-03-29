package com.beiwu.zhou.review2;

import com.beiwu.zhou.LinkedListNodeUtils;
import com.beiwu.zhou.ListNode;

/**
 * @author zhoubing
 * @date 2021-03-28 11:24
 */
public class S206 {

    public ListNode reverseList(ListNode head) {

        ListNode first = new ListNode(-1);

        while (head != null) {
            ListNode tmp = head.next;
            head.next = first.next;
            first.next = head;
            head = tmp;
        }

        return first.next;
    }


    public static void main(String[] args) {
        ListNode node = LinkedListNodeUtils.createLinkedList(new int[]{1, 2, 3, 4, 5, 6,});
        S206 s206 = new S206();
        ListNode reverseNode = s206.reverseList(node);
        LinkedListNodeUtils.printListNode(reverseNode);
    }
}

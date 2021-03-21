package com.beiwu.zhou.exercise;

import com.beiwu.zhou.LinkedListNodeUtils;
import com.beiwu.zhou.ListNode;

/**
 * @author zhoubing
 * @date 2021-03-20 22:17
 */
public class ReverseTwo {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = head;
        head = second;

        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;


            first = first.next;
            if (first != null && first.next != null){
                second = first.next;
                prev.next = second;
                prev = first;
            }else{
                second = null;
            }


        }

        return head;

    }


    public static void main(String[] args) {
        ListNode head = LinkedListNodeUtils.createLinkedList(new int[]{1, 2,3});
        ListNode reverse = new ReverseTwo().reverse(head);

        LinkedListNodeUtils.printListNode(reverse);
    }
}

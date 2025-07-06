package com.johar.test.algorithm.linkedlist;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: ReverseLinkedList
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/15 23:52
 * @Since: 1.0.0
 */
public class ReverseLinkedList {

    public static ListNode reverser(ListNode header){
        if (header == null){
            return null;
        }

        ListNode result = header;
        Deque<Integer> deque = new LinkedList<>();
        while (header != null){
            deque.push(header.val);
            header = header.next;
        }

        header = result;
        while (header != null){
            header.val = deque.pop();
            header = header.next;
        }

        return result;
    }

    public static ListNode reverseList1(ListNode head){
        ListNode prev = new ListNode();
        ListNode curr = head;
        while (curr != null){
            ListNode temp = new ListNode();
            temp.val = curr.val;
            temp.next = prev.next;
            prev.next = temp;
            curr = curr.next;
        }

        return prev.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode();
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = result.next;
            result.next = curr;

            curr = next;
        }

        return result.next;
    }
}
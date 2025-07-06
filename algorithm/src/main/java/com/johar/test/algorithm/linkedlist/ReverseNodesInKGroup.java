package com.johar.test.algorithm.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: ReverseNodesInKGroup
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/3/28 00:39
 * @Since: 1.0.0
 */
public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode cur = head;
        for (int i = 0; i < k; i++){
            if (cur == null){
                return head;
            }
            cur = cur.next;
        }
        ListNode temp = reverseKGroup(cur, k);
        ListNode pre = head;
        ListNode last = head;
        head = head.next;
        for (int i = 1; i < k; i++){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        last.next = temp;

        return pre;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode r1 = reverseKGroup(head, 2);
        System.out.println(r1);

        Deque<Character> characters = new LinkedList<>();

    }
}
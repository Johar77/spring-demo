package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.linkedlist.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/29 12:24]
 * @updateUser : [johar]
 * @updateTime : [2026/4/29 12:24]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode206 {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0, stack.peek());
        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop();
            tmp.next = stack.peek();
        }

        return dummy.next;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode next = head.next;
        ListNode nextNext = null;
        while (cur != null && next != null) {
            nextNext = next.next;
            next.next = cur;
            cur = next;
            next = nextNext;
        }
        head.next = null;

        return cur;
    }

    public static void main(String[] args) {
        LeetCode206 leetCode206 = new LeetCode206();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(leetCode206.reverseList1(head));
    }
}

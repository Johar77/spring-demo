package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.linkedlist.ListNode;

/**
 * @ClassName: RemoveDuplicatesFromSortedList
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/31 23:41
 * @Since: 1.0.0
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     *
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;
        while (current.next != null && current.next.next != null){
            if (current.next.val == current.next.next.val){
                int val = current.next.val;
                while (current.next != null && current.next.val == val){
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3))))));
        deleteDuplicates(node);
    }
}
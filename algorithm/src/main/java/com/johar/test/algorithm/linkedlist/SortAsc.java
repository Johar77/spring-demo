package com.johar.test.algorithm.linkedlist;

/**
 * @ClassName: AscOrder
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/2 21:14
 * @Since: 1.0.0
 */
public class SortAsc {

    /**
     * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail){
        if (head == null){
            return head;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode result = new ListNode();
        ListNode temp = result, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null){
            if (temp1.val < temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (temp1 != null){
            temp.next = temp1;
        }
        if (temp2 != null){
            temp.next = temp2;
        }

        return result.next;
    }
}
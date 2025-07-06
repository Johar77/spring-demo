package com.johar.test.algorithm.linkedlist;

/**
 * @ClassName: MergeSortLinkedList
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/16 00:28
 * @Since: 1.0.0
 */
public class MergeSortLinkedList {

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        while (l1 != null || l2 != null){
            if (l1 != null && l2 != null){
                if (l1.val <= l2.val){
                    temp.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    temp.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                temp = temp.next;
            } else if (l1 == null){
                temp.next = l2;
                break;
            } else if (l2 == null) {
                temp.next = l1;
                break;
            }
        }

        return result.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        while (l1 != null || l2 != null){
            if (l1 != null && l2 != null){
                if (l1.val <= l2.val){
                    temp.next = l1;
                    l1 = l1.next;
                } else {
                    temp.next = l2;
                    l2 = l2.next;
                }
                temp = temp.next;
            } else if (l1 == null){
                temp.next = l2;
                break;
            } else if (l2 == null) {
                temp.next = l1;
                break;
            }
        }

        return result.next;
    }
}
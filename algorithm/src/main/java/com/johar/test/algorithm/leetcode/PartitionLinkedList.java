package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.linkedlist.ListNode;

/**
 * @ClassName: PartitionLinkedList
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/6/3 18:04
 * @Since: 1.0.0
 */
public class PartitionLinkedList {

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     *
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/partition-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode less = null;
        ListNode greater = null;
        ListNode prev = null;
        while (curr != null){
            if (curr.val >= x){
                if (greater == null){
                    greater = curr;
                }
                prev = curr;
                curr = curr.next;
            } else {
                if (greater == null){
                    less = curr;
                    prev = curr;
                    curr = curr.next;
                } else {
                    ListNode next = curr.next;
                    if (prev != null){
                        prev.next = next;
                    }
                    if (less != null){
                        less.next = curr;
                        less = curr;
                    } else {
                        less = curr;
                        head = less;
                    }
                    curr.next = greater;
                    curr = next;
                }
            }
        }

        return head;
    }
}
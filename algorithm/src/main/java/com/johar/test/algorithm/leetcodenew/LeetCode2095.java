package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.linkedlist.ListNode;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/29 12:02]
 * @updateUser : [johar]
 * @updateTime : [2026/4/29 12:02]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode2095 {

    /**
     * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
     * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
     * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
     * @param head
     * @return
     */
    public ListNode deleteMiddle(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        ListNode pre = null;
        cur = head;
        int index = len / 2;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                if (pre == null) {
                    return pre;
                }
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }

        return head;
    }

    public ListNode deleteMiddle1(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (true) {
            if (fast != null) {
                fast = fast.next;
            }
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

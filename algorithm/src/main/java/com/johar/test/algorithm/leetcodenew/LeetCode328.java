package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.linkedlist.ListNode;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/odd-even-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/29 12:47]
 * @updateUser : [johar]
 * @updateTime : [2026/4/29 12:47]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode328 {

    /**
     * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别分组，保持它们原有的相对顺序，然后把偶数索引节点分组连接到奇数索引节点分组之后，返回重新排序的链表。
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0, head);
        ListNode oddTail = odd.next;
        ListNode even = new ListNode(0);
        ListNode evenTail = even;
        ListNode cur = head;
        ListNode next = null;
        ListNode nextNext = null;
        while (cur != null) {
            if (cur.next == null) {
                break;
            }
            next = cur.next;
            nextNext = next.next;

            evenTail.next = next;
            evenTail = evenTail.next;
            evenTail.next = null;

            cur.next = nextNext;
            oddTail = cur;
            cur = nextNext;
            if (cur != null) {
                oddTail = cur;
            }
        }
        if (oddTail != null) {
            oddTail.next = even.next;
        }

        return odd.next;
    }

    public static void main(String[] args) {
        LeetCode328 leetCode328 = new LeetCode328();
        leetCode328.oddEvenList(null);
    }
}

package com.johar.test.algorithm.linkedlist;

/**
 * @ClassName: SortAgain
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/3 15:24
 * @Since: 1.0.0
 */
public class SortAgain {

    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     *
     * L0→ L1→ … → Ln-1→ Ln
     * 请将其重新排列后变为：
     *
     * L0→Ln→L1→Ln-1→L2→Ln-2→ …
     *
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/LGjMqU
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        // 找到中间节点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            }
        }
        ListNode mid = slow.next;
        slow.next = null;
        // 后半截反转
        ListNode tail = reverse(mid);

        // 重新排序
        ListNode left = head;
        while (left != null && tail != null){
            ListNode leftNext = left.next;
            ListNode tailNext = tail.next;
            left.next = tail;
            tail.next = leftNext;
            left = leftNext;
            tail = tailNext;
        }
    }

    public static ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode tail = head;
        ListNode curr = head.next;
        tail.next = null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = tail;
            tail = curr;
            curr = next;
        }

        return tail;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2));
        ListNode.printListNode(node1);
        reorderList(node1);
        ListNode.printListNode(node1);
    }
}
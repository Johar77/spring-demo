package com.johar.test.algorithm.linkedlist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: CheckCicle
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/16 00:27
 * @Since: 1.0.0
 */
public class CheckCircle {

    /**
     * 剑指 Offer II 022. 链表中环的入口节点
     * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/c32eOV
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> hashSet = new HashSet<>();
        ListNode result = null;
        while (head != null){
            if (hashSet.contains(head)){
                result = head;
                break;
            } else {
                hashSet.add(head);
                head = head.next;
            }
        }

        return result;
    }

    public static ListNode detectCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (true){
            if (fast == null || fast.next == null){
                return null;
            } else {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow){
                    ListNode ptr = head;
                    while (ptr != slow) {
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
                }
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode three = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode four = new ListNode(4);
        head.next = three;
        three.next = zero;
        zero.next = four;
        four.next = three;

        System.out.println(detectCycle1(head));
    }
}
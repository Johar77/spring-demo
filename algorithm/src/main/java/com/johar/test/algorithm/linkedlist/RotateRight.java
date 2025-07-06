package com.johar.test.algorithm.linkedlist;

/**
 * @ClassName: RotateRight
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/3 22:38
 * @Since: 1.0.0
 */
public class RotateRight {

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (k < 1 || head == null || head.next == null){
            return head;
        }

        int length = 0;
        ListNode temp = head;
        ListNode tail = null;
        while (temp != null){
            length++;
            if (temp.next == null){
                tail = temp;
            }
            temp = temp.next;
        }

        int mod = k % length;
        if (mod == 0){
            return head;
        }

        int index = length - 1 - mod;
        ListNode dummyHead = null;
        int count = 0;
        temp = head;
        while (temp != null){
            if (count == index){
                dummyHead = temp.next;
                temp.next = null;
                tail.next = head;
                break;
            } else {
                count++;
                temp = temp.next;
            }
        }

        return dummyHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printListNode(node1);
        ListNode.printListNode(rotateRight(node1, 2));
    }
}
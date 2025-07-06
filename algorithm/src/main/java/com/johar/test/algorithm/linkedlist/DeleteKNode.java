package com.johar.test.algorithm.linkedlist;

/**
 * @ClassName: DeleteNode
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/16 00:28
 * @Since: 1.0.0
 */
public class DeleteKNode {

    /**
     * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        ListNode result = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }

        int index = length - n;
        int count = 0;
        ListNode prev = null;
        while (true){
            if (count == index){
                if (prev != null) {
                    prev.next = head.next;
                    head.next = null;
                } else {
                    result = head.next;
                }
                break;
            }
            prev = head;
            head = head.next;
            count++;
        }

        return result;
    }
}
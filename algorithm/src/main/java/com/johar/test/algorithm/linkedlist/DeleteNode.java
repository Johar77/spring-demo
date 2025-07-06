package com.johar.test.algorithm.linkedlist;

/**
 * @ClassName: DeleteNode
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/3 18:20
 * @Since: 1.0.0
 */
public class DeleteNode {

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点
     *
     * 题目保证链表中节点的值互不相同
     *
     * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null){
            if (current.val == val){
                ListNode next = current.next;
                if (prev != null){
                    prev.next = next;
                }
                current.next = null;
                break;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }
}
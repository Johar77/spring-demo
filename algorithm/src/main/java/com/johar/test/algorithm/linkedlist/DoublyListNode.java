package com.johar.test.algorithm.linkedlist;

/**
 * @ClassName: DoublyListNode
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/3 18:39
 * @Since: 1.0.0
 */
public class DoublyListNode extends ListNode {
    public ListNode prev;

    public DoublyListNode(int val, ListNode next, ListNode prev) {
        super(val, next);
        this.prev = prev;
    }
}
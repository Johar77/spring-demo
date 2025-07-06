package com.johar.test.algorithm.linkedlist;

/**
 * @ClassName: ListNode
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/17 23:11
 * @Since: 1.0.0
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void printListNode(ListNode head){
        ListNode temp = head;
        System.out.print("ListNode value: ");
        boolean first = true;
        while (temp != null){
            if (!first){
                System.out.print(" -> ");
            }
            System.out.print(temp.val);
            first = false;
            temp = temp.next;
        }
        System.out.println("");
    }
}
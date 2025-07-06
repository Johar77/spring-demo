package com.johar.test.algorithm.linkedlist;

/**
 * @ClassName: ReversePrint
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/3 17:26
 * @Since: 1.0.0
 */
public class ReversePrint {

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[0];
        }

        ListNode pre = null;
        ListNode curr = head;
        int count = 0;
        while (curr != null){
            count++;
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        int[] result = new int[count];
        ListNode temp = pre;
        count = 0;
        while (temp != null){
            result[count++] = temp.val;
            temp = temp.next;
        }

        return result;
    }
}
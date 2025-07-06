package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.linkedlist.ListNode;

/**
 * @ClassName: ReverseNodesInKGroup
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/4/2 22:02
 * @Since: 1.0.0
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2){
            return head;
        }

        int[] tempList = new int[k];
        ListNode result = new ListNode();
        ListNode tempNode = result;
        int i = 0;
        while (head != null){
            tempList[i] = head.val;
            if ((i + 1) % k == 0){
                for (int j = tempList.length - 1; j >= 0; j--){
                    tempNode.next = new ListNode(tempList[j]);
                    tempNode = tempNode.next;
                }
            }
            head = head.next;
            i = (++i) % k;
        }

        if (i > 0){
            for (int j = 0; j < i; j++){
                tempNode.next = new ListNode(tempList[j]);
                tempNode = tempNode.next;
            }
        }

        return result.next;
    }
}
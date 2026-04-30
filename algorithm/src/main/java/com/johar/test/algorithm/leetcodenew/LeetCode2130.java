package com.johar.test.algorithm.leetcodenew;

import com.johar.test.algorithm.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/29 15:46]
 * @updateUser : [johar]
 * @updateTime : [2026/4/29 15:46]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode2130 {

    /**
     * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
     * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
     * 孪生和 定义为一个节点和它孪生节点两者值之和。
     * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
     * @param head
     * @return
     */
    public int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int len = list.size();
        int index = len / 2 - 1;
        for (int i = 0; i <= index; i++) {
            int temp = list.get(i) + list.get(len - 1 - i);
            max = Math.max(max, temp);
        }

        return max;
    }
}

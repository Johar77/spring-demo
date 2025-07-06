package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: AddTwoNumbers
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/24 00:13
 * @Since: 1.0.0
 */
public class AddTwoNumbers {

    /**
     * 给定两个 非空链表 l1和 l2来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     *
     * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/lMSNwu
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);

        ListNode result = new ListNode();
        ListNode temp = result;
        int total = 0;
        int advance = 0;
        while (true){
            total = advance;
            if (r1 != null){
                total += r1.val;
                r1 = r1.next;
            }
            if (r2 != null){
                total += r2.val;
                r2 = r2.next;
            }
            if (total > 9){
                advance = 1;
            } else {
                advance = 0;
            }
            temp.val = total % 10;
            if (r1 == null && r2 == null && advance == 0){
                break;
            }
            temp.next = new ListNode();
            temp = temp.next;
        }

        return reverse(result);
    }

    private static ListNode reverse(ListNode node){
        if (node == null){
            return null;
        }

        ListNode curr = node.next;
        ListNode prev = node;
        prev.next = null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode result = null;
        int total = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0){
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            total = a + b + carry;
            carry = total / 10;
            total = total % 10;
            ListNode nodeNew = new ListNode(total);
            nodeNew.next = result;
            result = nodeNew;
        }

        return result;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(7,new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode.printListNode(addTwoNumbers(node1, node2));
    }

}
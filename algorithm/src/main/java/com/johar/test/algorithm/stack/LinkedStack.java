package com.johar.test.algorithm.stack;

import com.johar.test.algorithm.linkedlist.ListNode;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: LinkedStack
 * @Description:
 *  链表实现栈
 *  pop
 *  push
 *
 * @Author: Johar
 * @Date: 2023/1/18 00:01
 * @Since: 1.0.0
 */
public class LinkedStack implements Serializable {
    private ListNode head;

    public LinkedStack(){
        this.head = new ListNode();
    }

    public int pop(){
        if (head.next == null){
            return -1;
        }

        int result = head.next.val;
        head.next = head.next.next;
        return result;
    }

    public boolean push(int num){
        ListNode temp = new ListNode(num, this.head.next);
        this.head.next = temp;
        return true;
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        for (int i = 0; i < 10; i++){
            System.out.println(stack.push(i));
        }

        for (int i = 0; i < 10; i++){
            System.out.println(stack.pop());
        }
    }
}
package com.johar.test.algorithm.linkedlist;

/**
 * @ClassName: MyLinkedList
 * @Description:
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 *
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 *
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 *
 * 实现 MyLinkedList 类：
 *
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Johar
 * @Date: 2023/5/3 18:37
 * @Since: 1.0.0
 */
public class MyLinkedList {

    private DoublyListNode head;
    private DoublyListNode tail;
    private int size;

    public MyLinkedList() {
        head = new DoublyListNode();
        tail = new DoublyListNode();
        size = 0;
    }

    public int get(int index) {
        DoublyListNode node = getIndexNode(index);
        if (node == null){
            return -1;
        } else {
            return node.val;
        }
    }

    public void addAtHead(int val) {
        DoublyListNode newNode = new DoublyListNode(val);
        DoublyListNode next = head.next;
        newNode.next = next;
        if (tail.prev == null){
            tail.prev = newNode;
        }
        if (next != null){
            next.prev = newNode;
        }
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        DoublyListNode newNode = new DoublyListNode(val);
        DoublyListNode last = tail.prev;
        newNode.prev = last;
        if (head.next == null){
            head.next = newNode;
        }
        if (last != null){
            last.next = newNode;
        }
        tail.prev = newNode;

        size++;
    }

    public void addAtIndex(int index, int val) {
        if (size == index){
            addAtTail(val);
            return;
        }
        if (index == 0){
            addAtHead(val);
            return;
        }
        DoublyListNode node = getIndexNode(index);
        if (node == null){
            return;
        }

        DoublyListNode newNode = new DoublyListNode(val);
        newNode.prev = node.prev;
        newNode.next = node;
        DoublyListNode last = node.prev;
        last.next = newNode;
        node.prev = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size){
            return;
        }
        DoublyListNode node = getIndexNode(index);
        if (node == null){
            return;
        }
        DoublyListNode last = node.prev;
        DoublyListNode next = node.next;
        node.prev = null;
        node.next = null;
        if (last == null){
            head.next = next;
        } else {
            last.next = next;
        }
        if (next == null){
            tail.prev = last;
        } else {
            next.prev = last;
        }
        size--;
    }

    private DoublyListNode getIndexNode(int index){
        if (index >= size){
            return null;
        }

        int count = -1;
        DoublyListNode result = null;
        DoublyListNode temp = head.next;
        while (temp != null){
            count++;
            if (count == index){
                result = temp;
                break;
            }
            temp = temp.next;
        }

        return result;
    }

    static class DoublyListNode {
        public int val;
        public DoublyListNode next;
        public DoublyListNode prev;

        public DoublyListNode() {
        }

        public DoublyListNode(int val) {
            this.val = val;
        }

        public DoublyListNode(int val, DoublyListNode next) {
            this.val = val;
            this.next = next;
        }

        public DoublyListNode(int val, DoublyListNode next, DoublyListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
     * [[],             [7],        [2],        [1],        [3,0],      [2],            [6],        [4],        [4],    [4],        [5,0],      [6]]
     * @param args
     */
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        printListNode(myLinkedList.head.next);
        myLinkedList.addAtHead(2);
        printListNode(myLinkedList.head.next);
        myLinkedList.addAtHead(1);
        printListNode(myLinkedList.head.next);
        myLinkedList.addAtIndex(3, 0);
        printListNode(myLinkedList.head.next);
        myLinkedList.deleteAtIndex(2);
        printListNode(myLinkedList.head.next);
        myLinkedList.addAtHead(6);
        printListNode(myLinkedList.head.next);
        myLinkedList.addAtTail(4);
        printListNode(myLinkedList.head.next);
        System.out.println(myLinkedList.get(4));
        myLinkedList.addAtHead(4);
        printListNode(myLinkedList.head.next);
        myLinkedList.addAtIndex(5, 0);
        printListNode(myLinkedList.head.next);
        myLinkedList.addAtHead(6);
        printListNode(myLinkedList.head.next);
    }

    public static void printListNode(DoublyListNode head){
        DoublyListNode temp = head;
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
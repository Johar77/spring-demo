package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: CircleLinkedList
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/6/3 15:35
 * @Since: 1.0.0
 */
public class CircleLinkedList {

    /**
     * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素insertVal ，使这个列表仍然是循环升序的。
     *
     * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
     *
     * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
     *
     * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/4ueAj6
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @param insertVal
     * @return
     */
    public Node insert(Node head, int insertVal) {
        if (head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        Node dummyHead = head;
        while (true){
            if (insertVal == dummyHead.val || insertVal == dummyHead.next.val
                    || (insertVal > dummyHead.val && insertVal < dummyHead.next.val)
                    || (insertVal > dummyHead.val && dummyHead.val > dummyHead.next.val)
                    || (insertVal < dummyHead.next.val && dummyHead.val > dummyHead.next.val)){
                Node nodeNew = new Node(insertVal);
                nodeNew.next = dummyHead.next;
                dummyHead.next = nodeNew;
                break;
            } else {
                dummyHead = dummyHead.next;
            }
            if (dummyHead == head){
                Node nodeNew = new Node(insertVal);
                nodeNew.next = dummyHead.next;
                dummyHead.next = nodeNew;
                break;
            }
        }

        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
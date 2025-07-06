package com.johar.test.algorithm.leetcode;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.HashMap;

/**
 * @ClassName: CopyRandomList
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/6/3 09:11
 * @Since: 1.0.0
 */
public class CopyRandomList {

    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        Node copyHead = new Node(-1);
        Node copyTemp = new Node(-1);
        copyHead.next = copyTemp;
        Node current = head;
        HashMap<Node, Node> map = new HashMap<>();
        HashMap<Integer, Node> copyMap = new HashMap<>();
        while (current != null){
            copyTemp.val = current.val;
            map.put(current, copyTemp);
            current = current.next;
            if (current != null){
                copyTemp.next = new Node(-1);
                copyTemp = copyTemp.next;
            }
        }

        current = head;
        copyTemp = copyHead.next;
        while (current != null && copyTemp != null){
            copyTemp.random = map.get(current.random);
            current = current.next;
            copyTemp = copyTemp.next;
        }

        return copyHead.next;
    }

    public static Node copyRandomList1(Node head) {
        if (head == null){
            return null;
        }

        for (Node node = head; node != null; node = node.next.next){
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }

        for (Node node = head; node != null; node = node.next.next){
            Node nodeNew = node.next;
            nodeNew.random = node.random != null ? node.random.next : null;
        }

        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next){
            Node nodeNew = node.next;
            node.next = nodeNew.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }

        return headNew;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.random = node2;
        copyRandomList(node1);
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
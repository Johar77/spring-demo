package com.johar.test.algorithm.linkedlist;

import org.springframework.util.Assert;

import java.util.*;

/**
 * @ClassName: josephQuestion
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/15 18:57
 * @Since: 1.0.0
 */
public class JosephQuestion {

    /**
     * 现有T个人围成一桌坐下，编号从1到t，从编号为1的人开始报数。
     * 报数也从1开始，报到m的人离席，从离席者的下一位在座成员开始，继续从1开始报数。
     * 复现这个过程（各成员的离席次序），或者求最后一个在座的成员编号。
     * @param t 总人数
     * @param m 报数
     * @return 最后一个编号
     */
    public static int handler(int t, int m){
        if (t < 1 || m < 1){
            return -1;
        }

        Node<Integer> header = new Node<>(1, null, null);
        Node<Integer> last = header;
        for (int i = 1; i < t; i++){
            Node<Integer> temp = new Node<>(i + 1, last, null);
            last.next = temp;
            last = temp;
        }
        header.prev = last;
        last.next = header;
        int flag = 1;
        while (header.next != null){
            if (flag == m){
                if (header.prev.item.equals(header.next.item)){
                    header = header.next;
                    break;
                } else {
                    header.prev.next = header.next;
                    header.next.prev = header.prev;
                    flag = 1;
                    header = header.next;
                    header.prev.prev = null;
                    header.prev.next = null;
                }

            } else {
                flag++;
                header = header.next;
            }
        }

        return header.item;
    }

    public static List<Integer> handler1(int t, int m){
        if (t < 1 || m < 1){
            throw new IllegalArgumentException("参数不合法");
        }
        List<Integer> result = new ArrayList<>(t);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= t; i++){
            queue.offer(i);
        }

        int flag = 1;
        while (!queue.isEmpty()){
            if (flag >= m){
                result.add(queue.poll());
                flag = 1;
            } else {
                flag++;
                queue.offer(queue.poll());
            }
        }

        return result;
    }

    public static void main(String[] args){
        Assert.isTrue(handler(1, 1) == 1);
        Assert.isTrue(handler(2, 1) == 2);
        Assert.isTrue(handler(3, 3) == 2);

        System.out.println(handler1(1,1));
        System.out.println(handler1(2, 1));
        System.out.println(handler1(3, 3));
        System.out.println(handler1(41, 3));

        LinkedList list = new LinkedList();
    }

    static class Node<E> {
        public E item;
        public Node<E> prev;
        public Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
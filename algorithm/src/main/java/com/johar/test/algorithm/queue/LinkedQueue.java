package com.johar.test.algorithm.queue;

import java.io.Serializable;
import java.util.PriorityQueue;

/**
 * @ClassName: LinkedQueue
 * @Description: 元素从尾部入列，从头部出列
 * @Author: Johar
 * @Date: 2023/1/18 16:09
 * @Since: 1.0.0
 */
public class LinkedQueue<E> implements Serializable {

    private Node<E> head;
    private Node<E> tail;
    public LinkedQueue(){
        this.head = new Node<>();
        this.tail = head;
    }

    public boolean enqueue(E e){
        tail.next = new Node<E>(e);;
        tail = tail.next;
        return true;
    }

    public E dequeue(){
        if (head.next == null){
            return null;
        }

        E result = head.next.data;
        head.next = head.next.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> arrayQueue = new LinkedQueue<>();
        for (int i = 0; i < 10; i++){
            System.out.println(arrayQueue.enqueue(i));
        }

        for (int i = 0; i < 10; i++){
            System.out.println(arrayQueue.dequeue());
        }
        PriorityQueue queue = new PriorityQueue();
    }


    static class Node<E> implements Serializable {
        private E data;
        private Node<E> next;
        public Node(){

        }

        public Node(E data) {
            this.data = data;
        }
    }
}
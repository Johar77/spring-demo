package com.johar.test.algorithm.queue;

import java.io.Serializable;

/**
 * @ClassName: CircularQueue
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/18 16:30
 * @Since: 1.0.0
 */
public class CircularQueue<E> implements Serializable {
    private E[] data;
    private int size;
    private int head;
    private int tail;

    /**
     * 从头部出队，从尾部入队
     * @param size
     */
    public CircularQueue(int size){
        this.data = (E[]) new Object[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(E e){
        if ((tail + 1) % size == head){
            return false;
        }

        data[tail] = e;
        tail = (tail + 1) % size;
        return true;
    }

    public E dequeue(){
        if (head == tail){
            return null;
        }

        E result = data[head];
        head = (head + 1) % size;
        return result;
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(6);
        for (int i = 0; i < 10; i++){
            System.out.println(queue.enqueue(i));
        }

        for (int i = 0; i < 10; i++){
            System.out.println(queue.dequeue());
        }

        for (int i = 0; i < 10; i++){
            System.out.println(queue.enqueue(i));
        }
    }
}
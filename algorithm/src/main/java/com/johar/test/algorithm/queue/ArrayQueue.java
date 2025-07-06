package com.johar.test.algorithm.queue;

import java.io.Serializable;

/**
 * @ClassName: ArrayQueue
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/18 15:59
 * @Since: 1.0.0
 */
public class ArrayQueue<E> implements Serializable {

    private E[] data;
    private int size;
    private int head;
    private int tail;
    public ArrayQueue(int size){
        this.data = (E[])new Object[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(E e){
        if (tail >= size){
            return false;
        }

        data[tail] = e;
        tail++;
        return true;
    }

    public E dequeue(){
        if (tail <= head){
            return null;
        }

        E result = data[head];
        head++;
        return result;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(6);
        for (int i = 0; i < 10; i++){
            System.out.println(arrayQueue.enqueue(i));
        }

        for (int i = 0; i < 10; i++){
            System.out.println(arrayQueue.dequeue());
        }
    }
}
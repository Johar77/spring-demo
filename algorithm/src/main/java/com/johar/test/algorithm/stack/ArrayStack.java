package com.johar.test.algorithm.stack;

import java.io.Serializable;

/**
 * @ClassName: ArrayStack
 * @Description: 使用数组实现栈
 * push 入栈
 * pop 出栈
 *
 * @Author: Johar
 * @Date: 2023/1/17 23:43
 * @Since: 1.0.0
 */
public class ArrayStack<T> implements Serializable {

    private T[] data;
    private int count;
    private int size;

    public ArrayStack(int size){
        this.size = size;
        this.count = 0;
        this.data = (T[]) new Object[size];
    }

    public T pop(){
        if (count == 0){
            return null;
        }
        T result = data[count - 1];
        count--;
        return result;
    }

    public boolean push(T t){
        if (count == size){
            // 支持动态扩展
            int maxHalf = Integer.MAX_VALUE >> 1;
            int newSize = size;
            if (size < maxHalf){
                newSize = newSize << 1;
            } else {
                newSize = Integer.MAX_VALUE;
            }
            T[] newData = (T[])new Object[newSize];
            System.arraycopy(data, 0, newData, 0, count);
            this.data = newData;
            this.size = newSize;
        }
        data[count] = t;
        count++;

        return true;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(5);
        for (int i = 0; i < 10; i++){
            System.out.println(arrayStack.push(i));
        }

        for (int i = 0; i < 10; i++){
            System.out.println(arrayStack.pop());
        }
    }
}
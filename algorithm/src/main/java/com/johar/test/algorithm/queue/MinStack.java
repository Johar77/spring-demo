package com.johar.test.algorithm.queue;

import java.util.ArrayDeque;

/**
 *
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * @ClassName: MinStack
 * @Author: Johar
 * @Date: 2024/3/29 23:07
 * @Since: 1.0.0
 */
public class MinStack {

    private ArrayDeque<Integer> originalDeque = new ArrayDeque<>();
    private ArrayDeque<Integer> minDeque = new ArrayDeque<>();
    private Integer lastMinInt = null;

    public MinStack() {

    }

    public void push(int val) {
        if (originalDeque.isEmpty()){
            lastMinInt = val;
        }
        originalDeque.push(val);
        lastMinInt = Math.min(val, lastMinInt);
        minDeque.push(lastMinInt);
    }

    public void pop() {
        originalDeque.pop();
        minDeque.pop();
        if (!minDeque.isEmpty()) {
            lastMinInt = minDeque.peek();
        }
    }

    public int top() {
        return originalDeque.peek();
    }

    public int getMin() {
        return minDeque.peek();
    }
}
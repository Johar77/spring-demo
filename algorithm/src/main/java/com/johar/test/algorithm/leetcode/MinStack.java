package com.johar.test.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: MinStack
 * @Description:
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: Johar
 * @Date: 2023/7/1 10:40
 * @Since: 1.0.0
 */
public class MinStack {

    private Deque<Integer> dataDeque = new LinkedList<>();
    private Deque<Integer> minDeque = new LinkedList<>();
    private int min = Integer.MAX_VALUE;

    public MinStack() {
    }

    public void push(int val) {
        dataDeque.push(val);
        min = Math.min(val, min);
        minDeque.push(min);
    }

    public void pop() {
        dataDeque.pop();
        minDeque.pop();
        if (minDeque.isEmpty()){
            min = Integer.MAX_VALUE;
        } else {
            min = minDeque.peek();
        }
    }

    public int top() {
        return dataDeque.peek();
    }

    public int getMin() {
        return minDeque.peek();
    }
}
package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: MyCircularDeque
 * @Description:
 * 设计实现双端队列。
 *
 * 实现 MyCircularDeque 类:
 *
 * MyCircularDeque(int k)：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true，否则返回 false 。
 * boolean insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true，否则返回 false 。
 * boolean deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true，否则返回 false 。
 * boolean deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true，否则返回 false 。
 * int getFront())：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * int getRear()：获得双端队列的最后一个元素。如果双端队列为空，返回 -1 。
 * boolean isEmpty()：若双端队列为空，则返回true，否则返回 false 。
 * boolean isFull()：若双端队列满了，则返回true，否则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: Johar
 * @Date: 2023/7/4 23:42
 * @Since: 1.0.0
 */
public class MyCircularDeque {
    private int[] data;
    private int head;
    private int tail;
    private int size;
    private int count;

    public MyCircularDeque(int k) {
        this.size = k;
        this.data = new int[k+1];
        this.head = 0;
        this.tail = 1;
        this.count = 0;
    }

    public boolean insertFront(int value) {
        if (count == size) {
            return false;
        }
        data[head] = value;
        count++;
        if (head == 0){
            head = size;
        } else {
            head--;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (count == size) {
            return false;
        }
        data[tail] = value;
        count++;
        if (tail == size){
            tail = 0;
        } else {
            tail++;
        }
        return true;
    }

    public boolean deleteFront() {
        if (count == 0){
            return false;
        }
        head = (head + 1) % (size + 1);
        count--;
        return true;
    }

    public boolean deleteLast() {
        if (count == 0){
            return false;
        }
        if (tail == 0){
            tail = size;
        } else {
            tail--;
        }
        count--;
        return true;
    }

    public int getFront() {
        if (count == 0){
            return -1;
        }
        return data[(head + 1) % (size + 1)];
    }

    public int getRear() {
        if (count == 0){
            return -1;
        }
        if (tail == 0){
            return data[size];
        } else {
            return data[tail-1];
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        System.out.println(deque.insertLast(1));
        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertFront(3));
        System.out.println(deque.insertFront(4));
        System.out.println(deque.getRear());
        System.out.println(deque.isFull());
        System.out.println(deque.deleteLast());
        System.out.println(deque.insertFront(4));
        System.out.println(deque.getFront());
    }
}
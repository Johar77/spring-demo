package com.johar.test.algorithm.head;

/**
 * @ClassName: CustomHead
 * @Description:
 *
 * 堆是一个完全二叉树;堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值
 * 对于每个节点的值都大于等于子树中每个节点值的堆，我们叫做“大顶堆”。
 * 对于每个节点的值都小于等于子树中每个节点值的堆，我们叫做“小顶堆”。
 *
 * 用数组存储堆，数组中下标为 i 的节点的左子节点，就是下标为 i∗2 的节点，右子节点就是下标为 i∗2+1 的节点，父节点就是下标为 i/2 的节点。
 *
 * @Author: Johar
 * @Date: 2023/2/6 21:43
 * @Since: 1.0.0
 */
public class CustomHead {

    private int[] a;
    private int n;
    private int count;

    public CustomHead(int capacity){
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 可以让新插入的节点与父节点对比大小。如果不满足子节点小于等于父节点的大小关系，
     * 我们就互换两个节点。一直重复这个过程，直到父子节点之间满足刚说的那种大小关系。
     * @param data
     * @return
     */
    public boolean insert(int data){
        if (count >= n) {
            return false;
        }
        count++;
        a[count] = data;
        int i = count;
        int half = i >>> 1;
        while (half > 0 && a[i] > a[half]){
            swap(a, i, half);

            i = half;
            half = half >>> 1;
        }

        return true;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public boolean removeMax(){
        if (count == 0){
            return false;
        }

        a[1] = a[count];
        count--;
        heapify(a, count, 1);
        return true;
    }

    private void heapify(int[] a, int n, int i){
        while (true){
            int maxPos = i;
            int doubleMax = i >>> 1;
            if (doubleMax <= n && a[i] < a[doubleMax]) {
                maxPos = i * 2;
            }
            if (doubleMax + 1 <= n && a[i] < a[doubleMax + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i){
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }
}
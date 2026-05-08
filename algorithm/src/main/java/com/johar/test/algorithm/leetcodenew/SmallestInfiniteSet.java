package com.johar.test.algorithm.leetcodenew;

import java.util.PriorityQueue;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/smallest-number-in-infinite-set/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/5 12:06]
 * @updateUser : [johar]
 * @updateTime : [2026/5/5 12:06]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class SmallestInfiniteSet {

    private int low = 0;
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public SmallestInfiniteSet() {

    }

    public int popSmallest() {
        if (!queue.isEmpty()) {
           int res = queue.poll();
           while (!queue.isEmpty() && queue.peek() == res) {
               queue.poll();
           }
           return res;
        }

        int res = low;
        low++;
        return res;
    }

    public void addBack(int num) {
        if (num >= low) {
            return;
        }
        if (num == low - 1) {
            low--;
            return;
        }
        queue.add(num);
    }
}

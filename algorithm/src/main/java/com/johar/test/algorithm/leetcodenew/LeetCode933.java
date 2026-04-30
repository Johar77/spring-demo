package com.johar.test.algorithm.leetcodenew;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/number-of-recent-calls/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/27 12:17]
 * @updateUser : [johar]
 * @updateTime : [2026/4/27 12:17]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode933 {

    private Deque<Integer> queue = new ArrayDeque<Integer>();

    /**
     * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
     * 请你实现 RecentCounter 类：
     * RecentCounter() 初始化计数器，请求数为 0 。
     * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
     * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
     */
    public LeetCode933() {
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000){
            queue.poll();
        }

        return queue.size();
    }

    public static void main(String[] args) {
        LeetCode933 leetCode933 = new LeetCode933();
        System.out.println(leetCode933.ping(1));     // requests = [1]，范围是 [-2999,1]，返回 1
        System.out.println(leetCode933.ping(100));   // requests = [1, 100]，范围是 [-2900,100]，返回 2
        System.out.println(leetCode933.ping(3001));  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        System.out.println(leetCode933.ping(3002));  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
    }
}

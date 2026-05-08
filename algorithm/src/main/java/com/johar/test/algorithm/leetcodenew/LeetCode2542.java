package com.johar.test.algorithm.leetcodenew;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/maximum-subsequence-score/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/8 10:31]
 * @updateUser : [johar]
 * @updateTime : [2026/5/8 10:31]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode2542 {

    /**
     * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都是 n ，再给你一个正整数 k 。你必须从 nums1 中选一个长度为 k 的 子序列 对应的下标。
     * 对于选择的下标 i0 ，i1 ，...， ik - 1 ，你的 分数 定义如下：
     * nums1 中下标对应元素求和，乘以 nums2 中下标对应元素的 最小值 。
     * 用公式表示： (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]) 。
     * 请你返回 最大 可能的分数。
     * 一个数组的 子序列 下标是集合 {0, 1, ..., n-1} 中删除若干元素得到的剩余集合，也可以不删除任何元素。
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> nums2[j] - nums2[i]);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums1[ids[i]];
            queue.offer(nums1[ids[i]]);
        }

        long ans = sum * nums2[ids[k - 1]];
        for (int i = k; i < n; i++) {
            int x = nums1[ids[i]];
            if (x > queue.peek()) {
                sum += x - queue.poll();
                queue.offer(x);
                ans = Math.max(ans, sum * nums2[ids[i]]);
            }
        }

        return ans;
    }
}

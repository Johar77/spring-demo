package com.johar.test.algorithm.leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName: LargestPositiveInteger
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/14 14:23
 * @Since: 1.0.0
 */
public class LargestPositiveInteger {

    /**
     * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
     *
     * 返回正整数 k ，如果不存在这样的整数，返回 -1 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int findMaxK(int[] nums) {
        if (nums == null || nums.length == 1){
            return -1;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 -o1;
            }
        });
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0) {
                priorityQueue.offer(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }

        int result = -1;
        while (!priorityQueue.isEmpty()){
            Integer max = priorityQueue.poll();
            if (set.contains(-max)){
                result = max;
                break;
            }
        }

        return result;
    }
}
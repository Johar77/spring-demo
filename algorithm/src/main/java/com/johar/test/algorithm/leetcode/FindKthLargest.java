package com.johar.test.algorithm.leetcode;

import org.springframework.beans.factory.BeanNotOfRequiredTypeException;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName: FindKthLargest
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/28 00:07
 * @Since: 1.0.0
 */
public class FindKthLargest {

    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     *
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++){
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++){
            if (nums[i] <= queue.peek()){
                continue;
            }

            queue.poll();
            queue.offer(nums[i]);
        }

        return queue.poll();
    }
}
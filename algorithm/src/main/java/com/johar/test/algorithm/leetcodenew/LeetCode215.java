package com.johar.test.algorithm.leetcodenew;

import java.util.Arrays;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/5 11:53]
 * @updateUser : [johar]
 * @updateTime : [2026/5/5 11:53]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode215 {

    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


}

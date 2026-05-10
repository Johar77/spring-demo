package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/find-peak-element/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/10 10:47]
 * @updateUser : [johar]
 * @updateTime : [2026/5/10 10:47]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode162 {

    /**
     * 峰值元素是指其值严格大于左右相邻值的元素。
     * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * 你可以假设 nums[-1] = nums[n] = -∞ 。
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && i < n - 1 && nums[i] > nums[i - 1]  && nums[i] > nums[i + 1]) {
                return i;
            }
            if (i == 0 && nums[i] > nums[i + 1]) {
                return i;
            }
            if (i == n - 1 && nums[i] > nums[i - 1]) {
                return i;
            }
        }

        return -1;
    }
}

package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: MaximumSubarray
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/8/12 15:59
 * @Since: 1.0.0
 */
public class MaximumSubarray {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     *
     * https://leetcode.cn/problems/maximum-subarray/description/
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int result = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
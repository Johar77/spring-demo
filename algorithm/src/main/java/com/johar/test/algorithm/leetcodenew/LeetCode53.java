package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/5/28 11:25]
 * @updateUser : [johar]
 * @updateTime : [2026/5/28 11:25]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode53 {

    /**
     * 53. 最大子数组和
     * https://leetcode.cn/problems/maximum-subarray/?envType=study-plan-v2&envId=top-100-liked
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组是数组中的一个连续部分。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }

        return max;
    }
}

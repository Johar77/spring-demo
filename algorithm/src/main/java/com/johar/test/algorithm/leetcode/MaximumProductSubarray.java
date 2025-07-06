package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: MaximumProductSubarray
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/8/12 16:12
 * @Since: 1.0.0
 */
public class MaximumProductSubarray {

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     * 测试用例的答案是一个 32-位 整数。
     *
     * 子数组 是数组的连续子序列。
     *
     *
     * https://leetcode.cn/problems/maximum-product-subarray/description/
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        int result = nums[0];
        min[0] = nums[0];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            min[i] = Math.min(min[i - 1] * nums[i], Math.min(nums[i], max[i-1] * nums[i]));
            max[i] = Math.max(min[i - 1] * nums[i], Math.max(nums[i], max[i-1] * nums[i]));
            result = Math.max(result, max[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-3,7};
        System.out.println(maxProduct(nums));
    }
}
package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/24 10:09]
 * @updateUser : [johar]
 * @updateTime : [2026/4/24 10:09]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode643 {

    /**
     * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
     * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
     * 任何误差小于 10-5 的答案都将被视为正确答案。
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0.0;
        }
        int start = 0;
        int end = k - 1;
        int total = 0;
        for (int i = start; i <= end; i++) {
            total += nums[i];
        }
        int leftSum = 0;
        int rightSum = 0;
        while (end < nums.length - 1) {
            leftSum += nums[start];
            rightSum += nums[end + 1];
            if (rightSum > leftSum) {
                total += rightSum - leftSum;
                leftSum = 0;
                rightSum = 0;
            }
            start++;
            end++;
        }

        return total * 1.0D / k;
    }

    public static void main(String[] args) {
        LeetCode643 leetCode643 = new LeetCode643();
        System.out.println(leetCode643.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(leetCode643.findMaxAverage(new int[]{5}, 1));
    }
}

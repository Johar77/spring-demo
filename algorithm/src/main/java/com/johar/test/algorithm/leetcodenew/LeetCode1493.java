package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/24 11:43]
 * @updateUser : [johar]
 * @updateTime : [2026/4/24 11:43]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1493 {

    /**
     * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
     * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
     * 如果不存在这样的子数组，请返回 0 。
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int k = 1;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right++] == 0) {
                k--;
            }
            if (k < 0 && nums[left++] == 0) {
                k++;
            }
        }

        return right - left -1;
    }

    public static void main(String[] args) {
        LeetCode1493 leetcode1493 = new LeetCode1493();
        System.out.println(leetcode1493.longestSubarray(new int[]{1,1,0,1}));
        System.out.println(leetcode1493.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(leetcode1493.longestSubarray(new int[]{1,1,1}));
    }
}

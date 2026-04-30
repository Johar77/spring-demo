package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/24 10:48]
 * @updateUser : [johar]
 * @updateTime : [2026/4/24 10:48]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1004 {

    /**
     * 给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int total = 0;
        int start = 0;
        int end = 0;
        int oneLastIndex = 0;
        int tempZeroCount = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                tempZeroCount++;
                if (tempZeroCount > k) {
                    total = Math.max(total, end - start);
                    start = Math.max(oneLastIndex, start) + 1;
                    end = start;
                    tempZeroCount = 0;
                } else {
                    end++;
                }
            } else {
                if (tempZeroCount == 0) {
                    oneLastIndex = end;
                }
                end++;
            }

        }
        total = Math.max(total, end - start);

        return total;
    }

    public int longestOnes1(int[] A, int K) {
        int l = 0, r = 0;
        while (r < A.length) {
            if (A[r++] == 0) K--;
            if (K < 0 && A[l++] == 0) K++;
        }
        return r - l;
    }

    public static void main(String[] args) {
        LeetCode1004 leetcode1004 = new LeetCode1004();
        System.out.println(leetcode1004.longestOnes(new int[]{0,0,0,1}, 4));
        System.out.println(leetcode1004.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}

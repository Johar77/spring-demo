package com.johar.test.algorithm.leetcodenew;

import java.util.Arrays;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/22 10:43]
 * @updateUser : [johar]
 * @updateTime : [2026/4/22 10:43]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode238 {

    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i] 之外其余各元素的乘积 。
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int total = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            total *= num;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroCount > 1) {
                    res[i] = 0;
                } else {
                    res[i] = total;
                }
            } else {
                if (zeroCount > 0) {
                    res[i] = 0;
                } else {
                    res[i] = total / nums[i];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LeetCode238 leetCode238 = new LeetCode238();
        pintArray(leetCode238.productExceptSelf(new int[]{1, 2, 3, 4}));
        pintArray(leetCode238.productExceptSelf(new int[]{-1,1,0,-3,3}));
    }

    private static void pintArray(int[] nums) {
        String str = String.join(" ", Arrays.toString(nums));
        System.out.println(str);
    }
}

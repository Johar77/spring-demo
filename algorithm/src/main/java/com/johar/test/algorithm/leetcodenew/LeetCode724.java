package com.johar.test.algorithm.leetcodenew;

import java.util.Arrays;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/25 10:09]
 * @updateUser : [johar]
 * @updateTime : [2026/4/25 10:09]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode724 {

    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。
     * 这一点对于中心下标位于数组最右端同样适用。
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode724 leetCode724 = new LeetCode724();
//        System.out.println(leetCode724.pivotIndex(new int[] { 1,7,3,6,5,6 }));
//        System.out.println(leetCode724.pivotIndex(new int[] { 2,1,-1}));
        System.out.println(leetCode724.pivotIndex(new int[] { -1,-1,-1,-1,-1,0}));
    }
}

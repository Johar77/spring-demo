package com.johar.test.algorithm.leetcodenew;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/23 10:42]
 * @updateUser : [johar]
 * @updateTime : [2026/4/23 10:42]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1679 {

    /**
     * 给你一个整数数组 nums 和一个整数 k 。
     * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
     * 返回你可以对数组执行的最大操作数。
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length;i++) {
            int temp = k - nums[i];
            if (temp == nums[i]) {
                int count  = map.getOrDefault(temp, 0);
                if (count >= 2) {
                    result++;
                    removeMap(map, nums[i]);
                    removeMap(map, temp);
                }
            } else {
                if (map.containsKey(temp) && map.containsKey(nums[i])) {
                    result++;
                    removeMap(map, nums[i]);
                    removeMap(map, temp);
                }
            }
        }

        return result;
    }

    private void removeMap(Map<Integer, Integer> map, int num) {
        int count = map.get(num);
        if (count > 1) {
            map.put(num, count - 1);
        } else {
            map.remove(num);
        }
    }
}

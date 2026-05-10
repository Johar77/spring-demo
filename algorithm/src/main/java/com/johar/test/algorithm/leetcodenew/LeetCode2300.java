package com.johar.test.algorithm.leetcodenew;

import java.util.Arrays;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/9 11:07]
 * @updateUser : [johar]
 * @updateTime : [2026/5/9 11:07]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode2300 {

    /**
     * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
     * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
     * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] res = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            double min = success * 1.0D / spells[i];
            res[i] = countGreaterThan(potions, min);
        }

        return res;
    }

    private int countGreaterThan(int[] potions, double min) {
        if (potions == null || potions.length == 0) {
            return 0;
        }
        int low = 0;
        int high = potions.length - 1;
        int index = potions.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (potions[mid] >= min) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return potions.length - index;
    }

    public static void main(String[] args) {
        LeetCode2300 leetCode2300 = new LeetCode2300();
        int[] spells = new int[]{40,11,24,28,40,22,26,38,28,10,31,16,10,37,13,21,9,22,21,18,34,2,40,40,6,16,9,14,14,15,37,15,32,4,27,20,24,12,26,39,32,39,20,19,22,33,2,22,9,18,12,5};
        int[] potions = new int[]{31,40,29,19,27,16,25,8,33,25,36,21,7,27,40,24,18,26,32,25,22,21,38,22,37,34,15,36,21,22,37,14,31,20,36,27,28,32,21,26,33,37,27,39,19,36,20,23,25,39,40};
        int[] ans = leetCode2300.successfulPairs(spells, potions, 600L);
        System.out.println(Arrays.toString(ans));
    }
}

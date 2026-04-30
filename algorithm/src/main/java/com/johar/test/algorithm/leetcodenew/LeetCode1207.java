package com.johar.test.algorithm.leetcodenew;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/26 9:22]
 * @updateUser : [johar]
 * @updateTime : [2026/4/26 9:22]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1207 {

    /**
     * 给你一个整数数组 arr，如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer count = map.getOrDefault(arr[i], 0);
            map.put(arr[i], count + 1);
        }

        Set<Integer> countMap = map.values().stream().collect(Collectors.toSet());
        return countMap.size() == map.size();
    }

    public static void main(String[] args) {
        LeetCode1207 leetCode1207 = new LeetCode1207();
        System.out.println(leetCode1207.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(leetCode1207.uniqueOccurrences(new int[]{1,2}));
        System.out.println(leetCode1207.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}

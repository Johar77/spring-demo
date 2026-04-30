package com.johar.test.algorithm.leetcodenew;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/26 8:55]
 * @updateUser : [johar]
 * @updateTime : [2026/4/26 8:55]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode2215 {

    /**
     * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
     * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
     * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
     * 注意：列表中的整数可以按 任意 顺序返回。
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!set2.contains(nums1[i])) {
                list1.add(nums1[i]);
                set2.add(nums1[i]);
            }
        }

        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!set1.contains(nums2[i])) {
                list2.add(nums2[i]);
                set1.add(nums2[i]);
            }
        }

        result.add(list1);
        result.add(list2);

        return result;
    }

    public static void main(String[] args) {
        LeetCode2215 leetCode2215 = new LeetCode2215();
        System.out.println(leetCode2215.findDifference(new int[]{1, 2, 3}, new int[]{2,4,6}));
        System.out.println(leetCode2215.findDifference(new int[]{1, 2, 3,3}, new int[]{1,1,2,2}));
    }
}

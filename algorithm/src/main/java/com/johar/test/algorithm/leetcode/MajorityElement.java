package com.johar.test.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MajorityElement
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/23 11:02
 * @Since: 1.0.0
 */
public class MajorityElement {

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * https://leetcode.cn/problems/majority-element/description/
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        int half = nums.length >> 1;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++){
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
            if (count > half){
                return nums[i];
            }
        }
        return -1;
    }

    public int majorityElement(int[] nums){
        int count = 0;
        Integer candidate = null;
        for (int i = 0; i < nums.length; i++){
            if (count == 0){
                candidate = nums[i];
            }
            if (candidate == nums[i]){
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
package com.johar.test.algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: TwoSum
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/23 23:31
 * @Since: 1.0.0
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>(nums.length * 2);
        int repeatIndex = -1;
        for (int i = 0; i< nums.length; i++){
            if (numMap.containsKey(nums[i])){
                if (target == (nums[i] << 1)) {
                    repeatIndex = i;
                }
                continue;
            }
            numMap.putIfAbsent(nums[i], i);
        }

        Integer a = 0;
        for (int i = 0; i< nums.length; i++){
            a = target - nums[i];
            if (numMap.containsKey(a)){
                result[0] = i;
                if (a == nums[i]){
                    if (repeatIndex < 0){
                        continue;
                    }

                    result[1] = repeatIndex;
                } else {
                    result[1] = numMap.get(a);
                }
                break;
            }
        }

        return result;
    }

    public int[] twoSum1(int[] nums, int target){
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            if (map.containsKey(target - nums[i])){
                return new int[] { map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
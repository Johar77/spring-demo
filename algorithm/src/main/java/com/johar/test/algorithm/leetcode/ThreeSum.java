package com.johar.test.algorithm.leetcode;

import java.util.*;

/**
 * @ClassName: ThreeSum
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/6/20 03:23
 * @Since: 1.0.0
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++){
            if (nums[i] > 0) break;
            if (i > 0  && nums[i] == nums[i - 1]) continue;
            for (int l = i + 1, r = length - 1; l < r; ){
                int sum = nums[i] + nums[l] + nums[r];
                if ( sum == 0){
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while (l < length && nums[l-1] == nums[l]){
                        l++;
                    }
                    r--;
                } else if (sum > 0){
                    r--;
                } else {
                    l++;
                }
            }
        }

        return result;
    }
}
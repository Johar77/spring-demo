package com.johar.test.algorithm.leetcode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Subsets
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/23 07:22
 * @Since: 1.0.0
 */
public class Subsets {

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * https://leetcode.cn/problems/subsets/
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>>  subsets1(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++){
            int size = result.size();
            for (int j = 0; j < size; j++){
                List<Integer> t = new ArrayList<>(result.get(j));
                t.add(nums[i]);
                result.add(t);
            }
        }

        return result;
    }

    public List<List<Integer>>  subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int[] nums, int i, List<Integer> cur, List<List<Integer>> result){
        if (nums.length == i){
            result.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(nums, i + 1, cur, result);
        cur.remove(cur.size() - 1);
        dfs(nums, i + 1, cur, result);
    }

    public static void main(String[] args) {
        int[] n = new int[] {1,2,3};
        //subsets(n);
    }
}
package com.johar.test.algorithm.leetcode;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: Permutations
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/21 00:18
 * @Since: 1.0.0
 */
public class Permutations {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     * https://leetcode.cn/problems/permutations/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> out = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++){
            out.add(nums[i]);
        }
        backTrack(nums.length, out, result, 0);
        return result;
    }

    private void backTrack(int n, List<Integer> out, List<List<Integer>> result, int count){
        if (count == n){
            result.add(new ArrayList<>(out));
            return;
        }

        for (int i = count; i < n; i++){
            Collections.swap(out, count, i);
            backTrack(n, out, result, count + 1);
            Collections.swap(out, count, i);
        }
    }


    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     * https://leetcode.cn/problems/permutations-ii/
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> out = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++){
            out.add(nums[i]);
        }
        Set<String> set = new HashSet<>();
        backTrack2(nums.length, out, result, set, 0);

        return result;
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> out = new ArrayList<>(nums.length);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (!set.contains(i)){
                out.add(nums[i]);
                set.add(i);
            }
        }

        backTrack(nums.length, out, result, 0);

        return result;
    }

    private void backTrack2(int n, List<Integer> out, List<List<Integer>> result, Set<String> set, int count){
        if (count == n){
            String str = out.toString();
            if (!set.contains(str)){
                set.add(str);
                result.add(new ArrayList<>(out));
            }
            return;
        }

        for (int i = count; i < n; i++){
            Collections.swap(out, count, i);
            backTrack2(n, out, result, set,count + 1);
            Collections.swap(out, count, i);
        }
    }
}
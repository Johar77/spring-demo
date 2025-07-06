package com.johar.test.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Combinations
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/20 23:36
 * @Since: 1.0.0
 */
public class Combinations {

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 你可以按 任何顺序 返回答案。
     *
     * https://leetcode.cn/problems/combinations/
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        combine(1, n, 0, k, null, result);

        return result;
    }

    private void combine(int begin, int end, int count, int total, List<Integer> current, List<List<Integer>> result){
        if (count == total){
            result.add(current);
            return;
        }
        if (begin > end){
            return;
        }

        if (current == null){
            current = new LinkedList<>();
        }
        List<Integer> old = new LinkedList<>(current);
        current.add(begin);
        combine(begin + 1, end, count + 1, total, current, result);
        combine(begin + 1, end, count, total, old, result);
    }
}
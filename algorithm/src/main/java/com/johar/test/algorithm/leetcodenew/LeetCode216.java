package com.johar.test.algorithm.leetcodenew;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/combination-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/10 11:43]
 * @updateUser : [johar]
 * @updateTime : [2026/5/10 11:43]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode216 {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     * 只使用数字1到9
     * 每个数字 最多使用一次
     * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, 9, k, n);
        return ans;
    }

    private void dfs(int cur, int n, int k, int sum) {
        if (temp.size() > k || temp.size() + (n - cur + 1) < k) {
            return;
        }

        if (temp.size() == k) {
            int tempSum = 0;
            for (int num : temp) {
                tempSum += num;
            }
            if (tempSum == sum) {
                ans.add(new ArrayList<>(temp));
                return;
            }
        }

        temp.add(cur);
        dfs(cur + 1, n, k, sum);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k, sum);
    }
}

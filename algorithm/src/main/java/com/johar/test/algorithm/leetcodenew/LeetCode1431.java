package com.johar.test.algorithm.leetcodenew;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/21 11:37]
 * @updateUser : [johar]
 * @updateTime : [2026/4/21 11:37]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1431 {

    /**
     * 有 n 个有糖果的孩子。给你一个数组 candies，其中 candies[i] 代表第 i 个孩子拥有的糖果数目，
     * 和一个整数 extraCandies 表示你所有的额外糖果的数量。
     * 返回一个长度为 n 的布尔数组 result，如果把所有的 extraCandies 给第 i 个孩子之后，
     * 他会拥有所有孩子中 最多 的糖果，那么 result[i] 为 true，否则为 false。
     * 注意，允许有多个孩子同时拥有 最多 的糖果数目。
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        List<Boolean> result = new ArrayList<Boolean>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}

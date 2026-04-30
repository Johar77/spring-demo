package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/25 10:04]
 * @updateUser : [johar]
 * @updateTime : [2026/4/25 10:04]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1732 {

    /**
     * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
     * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。
     * 请你返回 最高点的海拔 。
     * @param gain
     * @return
     */
    public int largestAltitude(int[] gain) {
        if (gain == null || gain.length == 0) {
            return 0;
        }
        int temp = 0;
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            temp += gain[i];
            if (temp > max) {
                max = temp;
            }
        }

        return max;
    }
}

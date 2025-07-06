package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: HouseRobber
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/8/12 21:26
 * @Since: 1.0.0
 */
public class HouseRobber {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     *
     * https://leetcode.cn/problems/house-robber/description/
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[len];
    }


    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * https://leetcode.cn/problems/house-robber-ii/description/
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }

        int len = nums.length;
        int[] withZero = new int[len + 1];
        withZero[0] = 0;
        withZero[1] = nums[0];
        int[] noZero = new int[len + 1];
        noZero[0] = 0;
        noZero[1] = 0;
        for (int i = 2; i <= len; i++){
            withZero[i] = Math.max(withZero[i - 1], withZero[i - 2] + nums[i - 1]);
            noZero[i] = Math.max(noZero[i - 1], noZero[i - 2] + nums[i - 1]);
        }

        return Math.max(withZero[len -1], noZero[len]);
    }
}
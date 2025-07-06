package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: JumpGame
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/31 00:41
 * @Since: 1.0.0
 */
public class JumpGame {

    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     *
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     *
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     *
     * https://leetcode.cn/problems/jump-game-ii/
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int len = nums.length;
        int maxRight = 0;
        int index = 0;
        int result = 0;
        while (index < len){
            if (maxRight >= len - 1){
                if (index < len - 1){
                    result++;
                }
                break;
            }

            int next = index + nums[index];
            if (next >= len - 1){
                result++;
                break;
            }

            for (int i = index; i <= next; i++){
                int t = i + nums[i];
                if (t > maxRight){
                    index = i;
                    maxRight = t;
                }
            }
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        JumpGame obj = new JumpGame();
        obj.jump(new int[] { 1,1,1,1 });
    }
}
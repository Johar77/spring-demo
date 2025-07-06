package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: MaximizeTopMost
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/27 23:41
 * @Since: 1.0.0
 */
public class MaximizeTopMost {

    /**
     * 给你一个下标从 0开始的整数数组nums，它表示一个 栈 ，其中 nums[0]是栈顶的元素。
     *
     * 每一次操作中，你可以执行以下操作 之一：
     *
     * 如果栈非空，那么 删除栈顶端的元素。
     * 如果存在 1 个或者多个被删除的元素，你可以从它们中选择任何一个，添加回栈顶，这个元素成为新的栈顶元素。
     * 同时给你一个整数k，它表示你总共需要执行操作的次数。
     *
     * 请你返回 恰好执行 k次操作以后，栈顶元素的 最大值。如果执行完 k次操作以后，栈一定为空，请你返回 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximize-the-topmost-element-after-k-moves
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public int maximumTop(int[] nums, int k) {
        if (k == 0){
            return nums[0];
        }
        if (k == 1){
            if (nums.length > 1){
                return nums[1];
            } else {
                return -1;
            }
        }
        if (nums.length == 1){
            if (k % 2 == 0){
                return nums[0];
            } else {
                return -1;
            }
        }
        int num = Math.min(nums.length, k - 1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num; i++){
            if (nums[i] > max){
                max = nums[i];
            }
        }

        if (k + 1 <= nums.length && nums[k] > max){
            return nums[k];
        }

        return max;
    }
}
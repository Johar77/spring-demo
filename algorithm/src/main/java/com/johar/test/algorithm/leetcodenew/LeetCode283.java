package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/23 10:02]
 * @updateUser : [johar]
 * @updateTime : [2026/4/23 10:02]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode283 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) {
                    continue;
                }

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                break;
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int slow = 0;
        int fast = 1;
        for (; slow < nums.length - 1; slow++) {
            if (nums[slow] != 0) {
                fast++;
                continue;
            }
            if (fast > nums.length - 1) {
                break;
            }
            while (fast < nums.length - 1 && nums[fast] == 0) {
                fast++;
            }
            int temp = nums[slow];
            nums[slow] = nums[fast];
            nums[fast] = temp;
            fast++;
        }
    }
}

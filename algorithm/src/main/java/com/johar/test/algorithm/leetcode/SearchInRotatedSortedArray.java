package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: SearchInRotatedSortedArray
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/8/5 21:39
 * @Since: 1.0.0
 */
public class SearchInRotatedSortedArray {

    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     *
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     *
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     *
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     *
     * https://leetcode.cn/problems/search-in-rotated-sorted-array/
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int result = -1;
        int low = 0;
        int high = nums.length - 1;
        int lastIndex = nums.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target){
                result = mid;
                break;
            }
            if (nums[mid] >= nums[0]){
                if (nums[0] <= target && target < nums[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else{
                if (nums[mid] < target && nums[lastIndex] >= target){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6,7,0,1,2};
        System.out.println(search(nums, 6));
    }
}
package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: MergeSortedArray
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/7 15:22
 * @Since: 1.0.0
 */
public class MergeSortedArray {

    /**
     * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }

        int[] sorted = new int[m + n];
        int index1 = 0, index2 = 0;
        int current;
        while (index1 < m || index2 < n){
            if (index1 == m){
               current = nums2[index2++];
            } else if (index2 == n){
                current = nums1[index1++];
            } else if (nums1[index1] < nums2[index2]){
                current = nums1[index1++];
            } else {
                current = nums2[index2++];
            }
            sorted[index1 + index2 -1] = current;
        }

        for (int i = 0; i < m+n; i++){
            nums1[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 4,0,0,0,0,0, 0};
        int[] nums2 = new int[] { 1,2,3,5,6};
        merge(nums1, 1, nums2, 5);
    }
}
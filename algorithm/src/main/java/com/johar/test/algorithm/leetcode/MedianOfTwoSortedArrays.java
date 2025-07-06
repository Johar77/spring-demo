package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: MedianOfTwoSortedArrays
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/27 00:24
 * @Since: 1.0.0
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0d;
        int length = nums1.length + nums2.length;
        boolean isEven = length % 2 == 0;
        int middleIndex = length >> 1;

        int len1 = 0;
        int len2 = 0;
        int[] temps = new int[2];
        while (len1 < nums1.length || len2 < nums2.length){
            int index = (len1 + len2) % 2;
            if (len1 < nums1.length && len2 < nums2.length) {
                if (nums1[len1] <= nums2[len2]) {
                    temps[index] = nums1[len1];
                    len1++;
                } else {
                    temps[index] = nums2[len2];
                    len2++;
                }
            } else if (len1 >= nums1.length){
                temps[index] = nums2[len2];
                len2++;
            } else if (len2 >= nums2.length){
                temps[index] = nums1[len1];
                len1++;
            }

            if (len1 + len2 > middleIndex){
                if (isEven){
                    result = (temps[0] + temps[1]) / 2.0;
                } else {
                    result = temps[middleIndex % 2];
                }
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] n1 = new int[] {};
        int[] n2 = new int[] {1};
        MedianOfTwoSortedArrays.findMedianSortedArrays(n1, n2);
    }
}
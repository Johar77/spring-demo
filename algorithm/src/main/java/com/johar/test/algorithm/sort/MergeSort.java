package com.johar.test.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName: MergeSort
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/19 15:48
 * @Since: 1.0.0
 */
public class MergeSort {

    public static void mergeSort(int[] a, int n){
        mergeSortCounting(a, 0, n - 1);
    }

    private static void mergeSortCounting(int[] a, int p, int r){
        if (p >= r) {
            return;
        }
        int q = (p + r) >> 1;
        mergeSortCounting(a, p, q);
        mergeSortCounting(a, q + 1, r);
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r){
        int[] temp = new int[r-p+1];
        int i = p, j = q+1, k = 0;
        while (i <= q && j <= r){
            if (a[i] <= a[j]){
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= q){
            temp[k++] = a[i++];
        }
        while (j <= r){
            temp[k++] = a[j++];
        }
        for (int l = 0; l <= r-p; l++){
            a[p+l] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 5,2,3,1 };
        mergeSort(nums, nums.length);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}
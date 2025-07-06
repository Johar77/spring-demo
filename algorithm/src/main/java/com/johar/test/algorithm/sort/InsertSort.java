package com.johar.test.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName: InsertSort
 * @Description: 插入排序
 * @Author: Johar
 * @Date: 2023/1/19 15:29
 * @Since: 1.0.0
 */
public class InsertSort {

    public static void insertSort(int[] a, int n){
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++){
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--){
                if (a[j] > value){
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,1,3,2};
        insertSort(a, a.length);
        Arrays.stream(a).forEach(System.out::println);
    }
}
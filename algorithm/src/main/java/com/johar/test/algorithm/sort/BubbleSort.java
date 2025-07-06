package com.johar.test.algorithm.sort;

import org.springframework.beans.factory.FactoryBean;

import java.util.Arrays;

/**
 * @ClassName: Bubble
 * @Description: 冒泡排序
 * @Author: Johar
 * @Date: 2023/1/19 15:12
 * @Since: 1.0.0
 */
public class BubbleSort {


    /**
     * 从小到大排序
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n){
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++){
            boolean flag = true;
            for (int j = i + 1; j < n; j++){
                if (a[j] < a[i]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = { 3, 5, 4, 1, 2, 6};
        bubbleSort(a, a.length);
        System.out.println();
        Arrays.stream(a).forEach(System.out::println);
    }
}
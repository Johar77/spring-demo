package com.johar.test.algorithm.sort;

/**
 * @ClassName: CountingSort
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/7 11:46
 * @Since: 1.0.0
 */
public class CountingSort {

    public static void countingSort(int[] a, int n){
        if (n <= 1) {
            return;
        }

        int max = a[0];
        for (int i = 0; i < n; i++){
            if (a[i] > max){
                max = a[i];
            }
        }

        // 范围是[min, max]
        int[] c = new int[max + 1];
        for (int i = 0; i < c.length; i++){
            c[i] = 0;
        }

        for (int i = 0; i < n; i++){
            c[a[i]]++;
        }

        int index = 0;
        for (int i = 0; i < c.length; i++){
            while (c[i] > 0){
                a[index++] = i;
                c[i]--;
            }
        }
    }



    public static void main(String[] args) {
        int[] a = new int[] { 9,8,7,6,5,4,3,2,1,0,1,2,3,4,5};
        countingSort(a, a.length);
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]);
            System.out.print(',');
        }
        System.out.println(' ');
    }
}
package com.johar.test.algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName: SmallestKNum
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/27 23:04
 * @Since: 1.0.0
 */
public class SmallestKNum {

    public static int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(k);
        int length = arr.length;
        for (int i = 0; i < length; i++){
            priorityQueue.offer(arr[i]);
        }

        int[] result = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty()){
            result[i++] = priorityQueue.poll();
            if (i >= k){
                break;
            }
        }

        return result;
    }

    public static int[] smallestK1(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(smallestK1(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)).forEach(System.out::println);
    }
}
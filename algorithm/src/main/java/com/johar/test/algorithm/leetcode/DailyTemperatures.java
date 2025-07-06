package com.johar.test.algorithm.leetcode;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName: DailyTemperatures
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/4/1 11:58
 * @Since: 1.0.0
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures1(int[] temperatures) {
        int length = temperatures.length;
        if (length == 1){
            return new int[] { 0 };
        }
        // key: temperature  value: min index
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(length);
        int[] result = new int[length];
        for (int i = length - 1; i >= 0; i--){
            int temperature = temperatures[i];
            OptionalInt  minIndex = map.entrySet().stream().filter((item) -> item.getKey() > temperature).flatMapToInt((item) -> IntStream.of(item.getValue())).min();
            if (!minIndex.isPresent()){
                result[i] = 0;
            } else {
                result[i] = minIndex.getAsInt() - i;
            }
            map.put(temperature, i);
        }

        return result;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        if (length == 1){
            return new int[] { 0 };
        }
        int[] pos = new int[101];
        int[] result = new int[length];
        int max = -1;
        for (int i = length - 1; i >= 0; i--){
            int temperature = temperatures[i];
            if (max <= temperature){
                result[i] = 0;
            } else {
                int minIndex = Integer.MAX_VALUE;
                for (int j = temperature + 1; j < pos.length; j++){
                    if (pos[j] > 0){
                        minIndex = Math.min(minIndex, pos[j]);
                        if (minIndex - i == 1){
                            break;
                        }
                    }
                }
                result[i] = minIndex - i;
            }
            pos[temperature] = i;
            if (temperature > max){
                max = temperature;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        printArray(dailyTemperatures(new int[] { 73,74,75,71,69,72,76,73 }));
        printArray(dailyTemperatures(new int[] { 30,40,50,60 }));
        printArray(dailyTemperatures(new int[] { 30,60,90 }));
    }

    public static void printArray(int[] array){
        System.out.println();
        System.out.print("[");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            System.out.print(",");
        }
        System.out.print("]");
    }
}
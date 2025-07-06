package com.johar.test.algorithm.test;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @ClassName: Test1
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/3/5 23:42
 * @Since: 1.0.0
 */
public class Test1 {

    public static void main(String[] args) {
        Integer a = 1;
        long size = ObjectSizeCalculator.getObjectSize(a);
        System.out.println(size);
        String str1 = "";
        String str2 = null;
        String str3 = "舒强红";
        System.out.println(ObjectSizeCalculator.getObjectSize(str1));
        System.out.println(ObjectSizeCalculator.getObjectSize(str2));
        System.out.println(ObjectSizeCalculator.getObjectSize(str3));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> maps = new HashMap(nums.length);
        for (int i = 0; i < nums.length; i++){
            if (maps.containsKey(nums[i])){
                List<Integer> indexs = maps.get(nums[i]);
                indexs.add(i);
            } else {
                maps.put(nums[i], new ArrayList<Integer>(Arrays.asList(i)));
            }
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            int value = target - nums[i];
            if (maps.containsKey(value)){
                List<Integer> indexList = maps.get(value);
                if (nums[i] == value){
                    if (indexList.size() >= 2) {
                        result[0] = indexList.get(0);
                        result[1] = indexList.get(1);
                        break;
                    }
                } else {
                    result[0] = i;
                    result[1] = indexList.get(0);
                    break;
                }
            }
        }

        return result;
    }
}
package com.johar.test.algorithm.interview;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @ClassName: Solution1
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/4/8 11:32
 * @Since: 1.0.0
 */
public class Solution2 {

    public static ArrayList<Integer> extraNum (String s) {
        // write code here
        if (Objects.isNull(s) || s.length() == 0){
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        int length = s.length();
        Integer temp = 0;
        boolean hasNum = false;
        for (int i = 0; i < length; i++){
            char c = s.charAt(i);
            if (c >= 48 && c <= 57){
                hasNum = true;
                temp = temp * 10 + c - 48;
            } else {
                if (hasNum){
                    result.add(temp);
                    temp = 0;
                    hasNum = false;
                }
            }
        }

        if (hasNum){
            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(extraNum("c12m23b3n4t56"));
        System.out.println(extraNum("kur1su alan0233"));
    }



}
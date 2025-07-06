package com.johar.test.algorithm.leetcode;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ZigzagConversion
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/28 23:39
 * @Since: 1.0.0
 */
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        int length = s.length();
        if (numRows == 1 || s.length() < numRows){
            return s;
        }

        StringBuilder resultBuild = new StringBuilder(s.length());
        List<StringBuilder> list = new ArrayList<>(numRows);
        int col = length / (numRows - 1) + 1;
        for (int i = 0; i < numRows; i++){
            StringBuilder builder = new StringBuilder(col);
            list.add(builder);
        }

        char[] chars = s.toCharArray();
        int mod = numRows + numRows - 2;
        for (int i = 0; i < length; i++){
            int index = i % mod;
            if (index < numRows){
                list.get(index).append(chars[i]);
            } else {
                int row = numRows - 1 - (index - numRows + 1);
                list.get(row).append(chars[i]);
            }
        }

        for (int i = 0; i < numRows; i++){
            resultBuild.append(list.get(i).toString());
        }


        return resultBuild.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
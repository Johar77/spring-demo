package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/22 11:26]
 * @updateUser : [johar]
 * @updateTime : [2026/4/22 11:26]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode443 {

    /**
     * 给你一个字符数组 chars ，请使用下述算法压缩：
     * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
     * 如果这一组长度为 1 ，则将字符追加到 s 中。
     * 否则，需要向 s 追加字符，后跟这一组的长度。
     * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。
     * 需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
     * 请在 修改完输入数组后 ，返回该数组的新长度。
     * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
     * 注意：数组中超出返回长度的字符无关紧要，应予忽略。
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        int result = 1;
        char temp = chars[0];
        int writeIndex = 1;
        int tempCount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == temp) {
                tempCount++;
            } else {
                if (tempCount > 1) {
                    char[] charArray = String.valueOf(tempCount).toCharArray();
                    result+= charArray.length;
                    for (int j = 0; j < charArray.length; j++) {
                        chars[writeIndex++] = charArray[j];
                    }
                }
                result++;
                chars[writeIndex++] = chars[i];
                temp = chars[i];
                tempCount = 1;
            }
        }
        if (tempCount > 1) {
            char[] charArray = String.valueOf(tempCount).toCharArray();
            result+= charArray.length;
            for (int j = 0; j < charArray.length; j++) {
                chars[writeIndex++] = charArray[j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode443 leetCode443 = new LeetCode443();
        System.out.println(leetCode443.compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(leetCode443.compress(new char[]{'a'}));
    }
}

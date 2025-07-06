package com.johar.test.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName: RemoveLetterToEqualizeFrequency
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/4/29 15:17
 * @Since: 1.0.0
 */
public class RemoveLetterToEqualizeFrequency {

    /**
     * 给你一个下标从 0开始的字符串word，字符串只包含小写英文字母。你需要选择 一个下标并 删除下标处的字符，使得 word中剩余每个字母出现 频率相同。
     *
     * 如果删除一个字母后，word中剩余所有字母的出现频率都相同，那么返回 true，否则返回 false。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-letter-to-equalize-frequency
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param word
     * @return
     */
    public static boolean equalFrequency(String word) {
        Map<Character, Integer> charCountMap = new HashMap<>(39);
        char[] chars = word.toCharArray();
        for (char c : chars){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        Integer min = null;
        int minTime = 0;
        Integer max = null;
        int maxTime = 0;
        boolean first = true;
        for (Integer i : charCountMap.values()){
            if (first){
                first = false;
                min = i;
                minTime = 1;
            } else {
                if (min.equals(i)){
                    minTime++;
                } else if (Objects.nonNull(max) && max.equals(i)){
                    maxTime++;
                } else if (i < min){
                    if (maxTime > 0){
                        return false;
                    }
                    max = min;
                    maxTime = minTime;
                    min = i;
                    minTime = 1;
                } else if (i > min){
                    if (maxTime > 0){
                        return false;
                    }
                    max = i;
                    maxTime = 1;
                }
            }
        }

        if (maxTime == 0){
            if (minTime == 1 || min == 1){
                return true;
            } else {
                return false;
            }
        } else {
            if (maxTime > 1 && minTime > 1){
                return false;
            }
            if (max - min == 1 && maxTime == 1){
                return true;
            } if (minTime == 1 && min == 1){
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(equalFrequency("aaaabbbbccc"));
    }
}
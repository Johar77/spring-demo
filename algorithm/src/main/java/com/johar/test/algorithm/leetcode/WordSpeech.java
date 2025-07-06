package com.johar.test.algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: WordSpeech
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/7 17:26
 * @Since: 1.0.0
 */
public class WordSpeech {

    public static List<String> compute(String[] words){
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 1){
            return result;
        }

        int length = words.length;
        Map<String, Integer> scoreMap = new LinkedHashMap();
        String source = words[0];
        String chars = "qwertasdfgzxcvyuiophjklbnm";// 0-13 14-25
        Map<Character, Integer> charMap = new HashMap<>(52);
        for (int i = 0; i < chars.length(); i++){
            charMap.put(chars.charAt(i), i);
        }
        for (int i = 1; i < length; i++){
            int score = computeScore(source, words[i], charMap);
            scoreMap.put(words[i], score);
        }

        result = scoreMap.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        }).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
        return result;
    }

    public static int computeScore(String source, String target, Map<Character, Integer> charMap){
        if (source == null && target == null){
            return 0;
        }

        if (source ==  null){
            return target.length() * 3;
        }

        if (target == null){
            return source.length() * 3;
        }

        if (source.equals(target)){
            return 0;
        }

        int score = 0;
        int sourceLength = source.length();
        int targetLength = target.length();
        int length = Math.min(sourceLength, targetLength);
        score = Math.abs(sourceLength - targetLength) * 3;

        for (int i = 0; i < length; i++){
            if (target.charAt(i) == source.charAt(i)){
                continue;
            } else {
                Integer i1 = charMap.get(target.charAt(i));
                Integer i2 = charMap.get(source.charAt(i));
                if (i1 < 13 && i2 < 13) {
                    score = score + 1;
                } else if (i1 > 13 && i2 > 13){
                    score = score + 1;
                } else {
                    score = score + 2;
                }
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入目标单词，和若干字典单词，使用空格分隔：");
            String text = scanner.nextLine();

            String[] strArray = text.split(" ");
            List<String> result = compute(strArray);
            System.out.println("结果：" + String.join(",", result));
        }
    }
}
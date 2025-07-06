package com.johar.test.algorithm.leetcode;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @ClassName: ValidParentheses
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/6/26 23:38
 * @Since: 1.0.0
 */
public class ValidParentheses {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (!StringUtils.hasText(s)){
            return true;
        }

        boolean result = false;
        String temp = s;
        while (StringUtils.hasText(temp)){
            int size = temp.length();
            temp = temp.replace("()", "");
            if (temp.length() == 0){
                result = true;
                break;
            }
            temp = temp.replace("{}", "");
            if (temp.length() == 0){
                result = true;
                break;
            }
            temp = temp.replace("[]", "");
            if (temp.length() == 0){
                result = true;
                break;
            }
            if (size == temp.length()){
                result = false;
                break;
            }
        }

        return result;
    }

    public boolean isValid1(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            Character m = map.get(c);
            if (m != null){
                deque.push(m);
            } else {
                if (deque.isEmpty()){
                    return false;
                }

                Character top = deque.pop();
                if (top.equals(c)){
                    continue;
                } else {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}
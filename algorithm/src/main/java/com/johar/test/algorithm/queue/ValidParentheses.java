package com.johar.test.algorithm.queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: ValidParentheses
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/3/29 00:03
 * @Since: 1.0.0
 */
public class ValidParentheses {

    private Map<Character, Character> parenthesesMap = new HashMap<Character, Character>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    public boolean isValid(String s) {
        Deque<Character> characterDeque = new LinkedList<>();
        int length = s.length();
        for (int i = 0; i < length; i++){
            char c = s.charAt(i);
            if (parenthesesMap.containsKey(c)){
                characterDeque.push(c);
            } else {
                if (characterDeque.isEmpty()){
                    return false;
                }
                Character left = characterDeque.pop();
                if (!parenthesesMap.get(left).equals(c)){
                    return false;
                }
            }
        }

        return characterDeque.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(s));
    }
}
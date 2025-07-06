package com.johar.test.algorithm.linkedlist;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Objects;

/**
 * @ClassName: IsPalindromes
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/4/23 00:11
 * @Since: 1.0.0
 */
public class IsPalindromes {

    /**
     * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
     * 本题中，将空字符串定义为有效的 回文串 。
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (Objects.isNull(s) || s.length() == 0){
            return true;
        }

        StringBuilder stringBuilder = new StringBuilder(s.length());
        char zero = '0';
        char nine = '9';
        char upA = 'A';
        char upZ = 'Z';
        char downA = 'a';
        char downZ = 'z';
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c >= zero && c <= nine){
                stringBuilder.append(c);
            } else if(c >= upA && c <= upZ){
                stringBuilder.append((char)(c + 32));
            } else if(c >= downA && c <= downZ){
                stringBuilder.append(c);
            }
        }

        String actStr = stringBuilder.toString();
        System.out.println(actStr);
        int length = actStr.length();
        int middle = length >> 1;
        boolean result = true;
        for (int i = 0; i < middle; i++){
            if (actStr.charAt(i) != actStr.charAt(length - 1 - i)){
                result = false;
                break;
            }
        }

        return result;
    }

    public boolean isPalindrome(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head)){
            return true;
        }
        ListNode temp = new ListNode();
        ListNode slow = head;
        ListNode fast = head;
        ListNode up = null;
        ListNode down = null;
        while (true){
            fast = fast.next;
            if (fast == null){
                up = temp.next;
                down = slow.next;
                break;
            }
            ListNode next = slow.next;
            slow.next = temp.next;
            temp.next = slow;
            slow = next;

            fast = fast.next;
            if (fast == null){
                up = temp.next;
                down = slow;
                break;
            }
        }

        while (up != null && down != null){
            if (up.val != down.val){
                return false;
            }
            up = up.next;
            down = down.next;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
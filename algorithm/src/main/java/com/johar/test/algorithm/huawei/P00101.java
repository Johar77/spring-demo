package com.johar.test.algorithm.huawei;

import java.util.*;

/**
 * @author : [johar]
 * @description : https://hydro.ac/d/hwod_oj/p/P00101
 * @createTime : [2026/4/29 16:15]
 * @updateUser : [johar]
 * @updateTime : [2026/4/29 16:15]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class P00101 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String ciphertext = doHandleSingle(input);
            System.out.println(ciphertext);
        }
    }

    /**
     * 给你一串未加密的字符串str，通过对字符串的每一个字母进行改变来实现加密，加密方式是在每一个字母str[i]偏移特定数组元素a[i]的量，
     * 数组a前三位已经赋值：a[0]=1,a[1]=2,a[2]=4。
     * 当i>=3时，数组元素a[i]=a[i-1]+a[i-2]+a[i-3]。
     * 例如：原文 abcde 加密后 bdgkr，其中偏移量分别是1,2,4,7,13。
     * 输入描述:
     * 第一行为一个整数n（1<=n<=1000），表示有n组测试数据，每组数据包含一行，原文str（只含有小写字母，0<长度<=50）。
     * 输出描述:
     * 每组测试数据输出一行，表示字符串的密文。
     * 示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
     * 输入
     * 1
     * xy
     * 输出
     * ya
     * 说明
     * 第一个字符x偏移量是1，即为y，第二个字符y偏移量是2，即为a。
     * @param strList
     * @return
     */
    public List<String> handle(List<String> strList) {
        List<String> result = new ArrayList<>(strList.size());
        for (String str : strList) {
            result.add(doHandleSingle(str));
        }

        return result;
    }

    private static String doHandleSingle(String str) {
        int[] array = calculate(str.length());
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'a';
            char c = (char) ((num+ array[i]) % 26 + 'a');
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    private static int[] calculate(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[i]=1;
            } else if (i == 1) {
                result[i]=2;
            } else if (i == 2) {
                result[i]=4;
            } else {
                result[i]=result[i-1]+result[i-2]+result[i-3];
            }
        }

        return result;
    }
}

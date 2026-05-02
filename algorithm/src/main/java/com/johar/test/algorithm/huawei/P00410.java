package com.johar.test.algorithm.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : [johar]
 * @description : https://hydro.ac/d/hwod_oj/p/P00410
 * @createTime : [2026/5/1 16:13]
 * @updateUser : [johar]
 * @updateTime : [2026/5/1 16:13]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class P00410 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        String[] strArray = temp.split(" ");
        int len = Integer.parseInt(strArray[0]);
        int k = Integer.parseInt(strArray[1]);
        int[] arr = new int[len];
        temp = sc.nextLine();
        strArray = temp.split(" ");
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(strArray[i]);
        }

        long count = count(arr, k, len);
        System.out.println(arr);
    }

    private static long count(int[] arr, int k, int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        int countGEK = 0; // 频率>=k的元素个数
        int left = 0;
        long ans = 0;

        for (int right = 0; right < n; right++) {
            int val = arr[right];
            int f = freq.getOrDefault(val, 0) + 1;
            freq.put(val, f);
            if (f == k) {
                countGEK++;
            }
            // 当存在频率>=k的元素时，收缩左边界
            while (countGEK > 0) {
                int leftVal = arr[left];
                int leftFreq = freq.get(leftVal);
                if (leftFreq == k) {
                    countGEK--;
                }
                freq.put(leftVal, leftFreq - 1);
                left++;
            }
            ans += left;
        }

        return ans;
    }
}

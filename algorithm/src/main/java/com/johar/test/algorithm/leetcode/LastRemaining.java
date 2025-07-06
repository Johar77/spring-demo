package com.johar.test.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: LastRemaining
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/28 15:56
 * @Since: 1.0.0
 */
public class LastRemaining {

    /**
     * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
     *
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++){
            queue.offer(i);
        }

        int result = -1;
        int count = 0;
        do {
            count++;
            result = queue.poll();
            if (count % m > 0){
              queue.offer(result);
            }
            if (queue.size() == 1){
                break;
            }
        } while (true);
        result = queue.poll();

        return result;
    }

    public static int lastRemaining1(int n, int m){
        return f(n, m);
    }

    public static int lastRemaining2(int n, int m){
        int x = 0;
        for (int i = 2; i <= n; i++){
            x = (x + m ) % i;
        }

        return x;
    }

    public static int f(int n, int m){
        if (n == 1){
            return 0;
        }

        int x = f(n -1, m);
        return (x + m) % n;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }
}
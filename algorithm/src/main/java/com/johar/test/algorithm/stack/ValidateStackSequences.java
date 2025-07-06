package com.johar.test.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: ValidateStackSequences
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/4 22:47
 * @Since: 1.0.0
 */
public class ValidateStackSequences {

    /**
     * 给定pushed和popped两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/validate-stack-sequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || pushed.length == 0){
            return true;
        }
        int length = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>(length);
        int pushIndex = 0;
        int poppedIndex = 0;
        while (poppedIndex < length){
            Integer head = stack.peek();
            if (head != null && head == popped[poppedIndex]){
                stack.pop();
                poppedIndex++;
            } else {
                if (pushIndex >= length){
                    break;
                }
                stack.push(pushed[pushIndex]);
                pushIndex++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = new int[] { 1,2,3,4,5};
        int[] pop = new int[] { 4,5,3,2,1};
        System.out.println(validateStackSequences(push, pop));
        System.out.println(validateStackSequences(new int[] { 1,2,3,4,5}, new int[] { 4,3,5,1,2}));
    }
}
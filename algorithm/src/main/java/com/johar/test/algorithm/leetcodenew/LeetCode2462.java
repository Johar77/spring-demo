package com.johar.test.algorithm.leetcodenew;

import java.util.PriorityQueue;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/total-cost-to-hire-k-workers/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/8 11:05]
 * @updateUser : [johar]
 * @updateTime : [2026/5/8 11:05]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode2462 {


    /**
     * 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。
     * 同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：
     * 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
     * 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
     * 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
     * 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
     * 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
     * 一位工人只能被选择一次。
     * 返回雇佣恰好 k 位工人的总代价。
     * @param costs
     * @param k
     * @param candidates
     * @return
     */
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>(candidates, (i, j) -> costs[i] - costs[j]);
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>(candidates, (i, j) -> costs[i] - costs[j]);
        int left = 0;
        for (; left < candidates; left++) {
            leftQueue.offer(left);
        }
        int right = n - 1;
        for (; right >= n - candidates; right--) {
            rightQueue.offer(right);
        }

        long ans = 0;
        for (int i = 0; i < k; i++) {
            Integer leftMinIndex = peekMinIndex(leftQueue, visited);
            Integer rightMinIndex = peekMinIndex(rightQueue, visited);
            if (leftMinIndex != null && rightMinIndex != null) {
                if (costs[leftMinIndex] <= costs[rightMinIndex]) {
                    leftQueue.poll();
                    ans += costs[leftMinIndex];
                    System.out.println(costs[leftMinIndex]);
                    visited[leftMinIndex] = true;
                    while (left <= right) {
                        if (!visited[left]) {
                            leftQueue.offer(left++);
                            break;
                        } else {
                            left++;
                        }
                    }
                } else {
                    rightQueue.poll();
                    ans += costs[rightMinIndex];
                    System.out.println(costs[rightMinIndex]);
                    visited[rightMinIndex] = true;
                    while (right >= left) {
                        if (!visited[right]) {
                            rightQueue.offer(right--);
                            break;
                        } else {
                            right--;
                        }
                    }
                }
            } else {
                if (leftMinIndex == null) {
                    rightQueue.poll();
                    ans += costs[rightMinIndex];
                    System.out.println(costs[rightMinIndex]);
                    visited[rightMinIndex] = true;
                    while (right >= left) {
                        if (!visited[right]) {
                            rightQueue.offer(right--);
                            break;
                        } else {
                            right--;
                        }
                    }
                } else if (rightMinIndex == null) {
                    leftQueue.poll();
                    ans += costs[leftMinIndex];
                    System.out.println(costs[leftMinIndex]);
                    visited[leftMinIndex] = true;
                    while (left <= right) {
                        if (!visited[left]) {
                            leftQueue.offer(left++);
                            break;
                        } else {
                            left++;
                        }
                    }
                } else {
                    break;
                }
            }

        }

        return ans;
    }

    private Integer peekMinIndex(PriorityQueue<Integer> queue, boolean[] visited) {
        while (!queue.isEmpty()) {
            if (visited[queue.peek()]) {
                queue.poll();
            } else {
                return queue.peek();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] costs = new int[]{31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58};
        LeetCode2462 leetCode2462 = new LeetCode2462();
        long ans = leetCode2462.totalCost(costs, 11, 2);
        System.out.println(ans);
    }
}

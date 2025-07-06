package com.johar.test.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: WalkingRobotSimulation
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/30 23:02
 * @Since: 1.0.0
 */
public class WalkingRobotSimulation {

    /**
     * 第0行：面朝正北
     * 第1行：面朝正东
     * 第2行：面朝正南
     * 第3行：面朝正西
     *
     * 同时使用使用数组int[3] 代表当前位置，int[0]表示x，int[1]表示y
     * 其计算公式：
     * x += x * p
     * y += y * p
     * z =
     *
     */
    private int[][] operators = new int[][] {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    private int[][] directions = new int[][] {
            {1, 3 },
            {2, 0},
            {3, 1},
            {0, 2}
    };

    /**
     * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
     *
     * -2 ：向左转 90 度
     * -1 ：向右转 90 度
     * 1 <= x <= 9 ：向前移动 x 个单位长度
     * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
     *
     * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，并继续执行下一个命令。
     *
     * 返回机器人距离原点的 最大欧式距离 的 平方 。（即，如果距离为 5 ，则返回 25 ）
     *
     *
     * 注意：
     *
     * 北方表示 +Y 方向。
     * 东方表示 +X 方向。
     * 南方表示 -Y 方向。
     * 西方表示 -X 方向。
     * 原点 [0,0] 可能会有障碍物。
     *
     * https://leetcode.cn/problems/walking-robot-simulation/description/
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || commands.length == 0){
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++){
            set.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        int result = 0;
        int[] current = new int[] { 0,0,0 };
        for (int i = 0; i < commands.length; i++){
            if (commands[i] < 0){
                int op = 0;
                if (commands[i] == -2){
                    op = 1;
                }
                current[2] = directions[current[2]][op];
            } else {
                int[] op = operators[current[2]];
                int x = current[0] + commands[i] * op[0];
                int y = current[1] + commands[i] * op[1];

                int lastX = current[0];
                int lastY = current[1];
                for (int j = 1; j <= commands[i]; j++){
                    int newX = current[0] + j * op[0];
                    int newY = current[1] + j * op[1];
                    if (set.contains(newX + "," + newY)){
                        x = lastX;
                        y = lastY;
                        break;
                    } else {
                        lastX = newX;
                        lastY = newY;
                    }
                }
                current[0] = x;
                current[1] = y;
                result = Math.max(result, x * x + y * y);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        WalkingRobotSimulation ob = new WalkingRobotSimulation();
        ob.robotSim(new int[] {-2,8,3,7,-1}, new int[][] { {-4,-1},{1,-1},{1,4},{5,0},{4,5},{-2,-1},{2,-5},{5,1},{-3,-1},{5,-3} });
    }
}
package com.beiwu.zhou.review1;

import java.util.HashSet;
import java.util.Set;
import javafx.util.Pair;

/**
 * @author zhoubing
 * @date 2021-04-08 15:57
 */
public class S874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};


        Set<Pair<Integer, Integer>> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            // 将障碍物加入
            obstacleSet.add(new Pair<>(obstacle[0], obstacle[1]));
        }
        // 如果是 向北走 向东走 向南走 向西走
        // 即 +(0,1) +(1,0)  +(0,-1)   +(-1,0)
        // 如果是向右转 就(direction+1)%length
        int direction = 0;

        int x = 0, y = 0;
        int max = 0;

        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if (command > 0) {
                // 是行走的信号
                for (int j = 0; j < command; j++) {
                    // 走command步骤 每走一步就判断 下一步是不是有障碍物 如果没有 就可以走
                    Pair<Integer, Integer> newLocation =
                        new Pair<>(x + dx[direction], y + dy[direction]);
                    if (!obstacleSet.contains(newLocation)) {
                        // 如果不包含在障碍物中 就往前走 否则就不走
                        x += dx[direction];
                        y += dy[direction];
                    }
                }

                max = Math.max(max, x * x + y * y);
            } else if (command == -1) {
                // -1  向右转
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction - 1 + 4) % 4;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        S874 s874 = new S874();
        int distance = s874.robotSim(new int[] {4, -1, 4, -2, 4}, new int[][] {{2, 4}});
        System.out.println(distance);
    }
}

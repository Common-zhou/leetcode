package com.beiwu.zhou.review2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author zhoubing
 * @date 2021-04-21 00:18
 */
public class S874 {
    class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Position position = (Position) o;
            return x == position.x &&
                y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int robotSim(int[] commands, int[][] obstacles) {

        Set<Position> obstaclePositionSet = new HashSet<>();

        for (int[] obstacle : obstacles) {
            obstaclePositionSet.add(new Position(obstacle[0], obstacle[1]));
        }

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        // 向北出发  坐标变换 (0,1)
        // 左转 就是 (direction -1 + length )%length
        // 右转 就是(direction +1 )%length
        int direction = 0;

        int x = 0, y = 0;

        int maxLength = 0;

        for (int command : commands) {
            if (command < 0) {
                // 代表是调整方向
                if (command == -1) {
                    direction = (direction + 1) % 4;
                } else {
                    direction = (direction - 1 + 4) % 4;
                }
            } else {
                // 代表是行走
                for (int i = 0; i < command; i++) {
                    // 行走 command步  如果下一步不为障碍物 就可以往前出发
                    if (!obstaclePositionSet
                        .contains(new Position(x + dx[direction], y + dy[direction]))) {
                        x = x + dx[direction];
                        y = y + dy[direction];
                        maxLength = Math.max(maxLength, x * x + y * y);
                    }
                }
            }
        }
        return maxLength;

    }
}

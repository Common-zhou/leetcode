package com.beiwu.zhou;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author zhoubing
 * @date 2021-04-07 11:53
 */
public class SolutionNo874 {

    class Location {
        int x;
        int y;

        public Location(int x, int y) {
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
            Location location = (Location) o;
            return x == location.x &&
                y == location.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        // 向y轴正方向  x轴正方向 y轴负方向 x轴负方向
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};

        Set<Location> obstaclesSet = new HashSet<>();

        for (int[] obstacle : obstacles) {
            Location location = new Location(obstacle[0], obstacle[1]);
            obstaclesSet.add(location);
        }

        int x = 0;
        int y = 0;

        int max = 0;

        int direction = 0;
        for (int command : commands) {
            if (command > 0) {
                // 直接挪
                if (dx[direction] != 0) {
                    for (int i = 0; i < command; i++) {
                        // 如果不包含障碍物 就进
                        if (!obstaclesSet.contains(new Location(x + dx[direction], y))) {
                            x += dx[direction];
                        } else {
                            break;
                        }
                    }
                }

                if (dy[direction] != 0) {
                    for (int i = 0; i < command; i++) {
                        if (!obstaclesSet.contains(new Location(x, y + dy[direction]))) {
                            y += dy[direction];
                        } else {
                            break;
                        }
                    }

                }

                max = Math.max(max, x * x + y * y);
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction - 1 + 4) % 4;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        SolutionNo874 solution = new SolutionNo874();
        int sim = solution.robotSim(new int[] {4, -1, 4, -2, 4}, new int[][] {{2, 4}});
        System.out.println(sim);
    }

}

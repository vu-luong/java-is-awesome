package com.vuluong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination2 {

    public static class Solution {

        public static class State {
            int x, y, e, cost;

            public State(int x, int y, int e, int cost) {
                this.x = x;
                this.y = y;
                this.e = e;
                this.cost = cost;
            }
        }
        
        public int shortestPath(int[][] grid, int k) {
            int[] dx = new int[] {0, 0, -1, 1};
            int[] dy = new int[] {-1, 1, 0, 0};
            
            int m = grid.length;
            int n = grid[0].length;
            
            boolean[][][] visited = new boolean[m][n][k + 1];
            
            Queue<State> queue = new LinkedList<>();
            queue.add(new State(0, 0, 0, 0));
            
            while (!queue.isEmpty()) {
                State currentState = queue.poll();
                int currentX = currentState.x;
                int currentY = currentState.y;
                int currentE = currentState.e;
                int currentCost = currentState.cost;

                if (currentX == m - 1 && currentY == n - 1) {
                    return currentCost;
                }
                for (int i = 0; i < 4; i++) {
                    int nextX = currentX + dx[i];
                    int nextY = currentY + dy[i];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                        if (grid[nextX][nextY] == 0) {
                            if (!visited[nextX][nextY][currentE]) {
                                visited[nextX][nextY][currentE] = true;
                                queue.add(new State(nextX, nextY, currentE, currentCost + 1));
                            }
                        } else {
                            if (currentE < k && !visited[nextX][nextY][currentE + 1]) {
                                visited[nextX][nextY][currentE + 1] = true;
                                queue.add(new State(nextX, nextY, currentE + 1, currentCost + 1));
                            }
                        }
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
            sol.shortestPath(
                new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}},
                1
            )
        );

        System.out.println(
            sol.shortestPath(
                new int[][]{{0,1,1},{1,1,1},{1,0,0}},
                1
            )
        );

        System.out.println(
            sol.shortestPath(
                new int[][]{{0}},
                1
            )
        );
    }
}

package com.vuluong.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumObstacleRemovalToReachCorner {

    static class Solution {
        
        public static class State {
            int x, y;

            public State(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        
        public int minimumObstacles(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            
            int[] dx = new int[] {0, 0, -1, 1};
            int[] dy = new int[] {-1, 1, 0, 0};
            
            int[][] dp = new int[m][n];
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = 1000000007;
                }
            }
            
            Deque<State> queue = new LinkedList<>();
            queue.add(new State(0, 0));
            dp[0][0] = 0;
            
            while (!queue.isEmpty()) {
                State currentState = queue.poll();
                
                if (currentState.x == m - 1 && currentState.y == n - 1) {
                    return dp[m - 1][n - 1]; // need addFirst, addLast to do this
                }
                
                for (int i = 0; i < 4; i++) {
                    int nextX = currentState.x + dx[i];
                    int nextY = currentState.y + dy[i];
                    if (0 <= nextX && nextX <= m - 1 && 0 <= nextY && nextY <= n - 1) {
                        if (grid[nextX][nextY] == 0) {
                            if (dp[currentState.x][currentState.y] < dp[nextX][nextY]) {
                                dp[nextX][nextY] = dp[currentState.x][currentState.y];
                                queue.addFirst(new State(nextX, nextY));
                            }
                        } else {
                            if (dp[currentState.x][currentState.y] + 1 < dp[nextX][nextY]) {
                                dp[nextX][nextY] = dp[currentState.x][currentState.y] + 1;
                                queue.addLast(new State(nextX, nextY));
                            }
                        }
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
            sol.minimumObstacles(
                new int[][]{{0,1,1},{1,1,0},{1,1,0}}
            )
        );

        System.out.println(
            sol.minimumObstacles(
                new int[][]{{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}}
            )
        );

        System.out.println(
            sol.minimumObstacles(
                new int[][]{{0}}
            )
        );
    }
}

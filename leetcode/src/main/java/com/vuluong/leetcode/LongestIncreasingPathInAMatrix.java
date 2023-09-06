package com.vuluong.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LongestIncreasingPathInAMatrix {

    public static class Solution {
        
        public static class State {
            int x, y, val;

            public State(int x, int y, int val) {
                this.x = x;
                this.y = y;
                this.val = val;
            }
        }
        
        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[] dx = new int[] {1, -1, 0, 0};
            int[] dy = new int[] {0, 0, -1, 1};
            int[][] dp = new int[m][n];
            List<State> states = new ArrayList<>();
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    states.add(new State(i, j, matrix[i][j]));
                }
            }
            
            states.sort(Comparator.comparingInt(s -> s.val));
            int res = 0;
            
            for (State state : states) {
                int x = state.x;
                int y = state.y;
                dp[x][y] = 1;
                
                for (int i = 0; i < 4; i++) {
                    int adjX = x + dx[i];
                    int adjY = y + dy[i];
                    if (0 <= adjX && adjX < m && 0 <= adjY && adjY < n) {
                        if (matrix[adjX][adjY] < matrix[x][y]) {
                            dp[x][y] = Math.max(dp[x][y], dp[adjX][adjY] + 1);
                        }
                    }
                }
                res = Math.max(res, dp[x][y]);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
            sol.longestIncreasingPath(
                new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}
            )
        );

        System.out.println(
            sol.longestIncreasingPath(
                new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}
            )
        );
    }
}

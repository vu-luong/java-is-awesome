package com.vuluong.leetcode;

public class MaximumNumberOfPointsWithCost {

    public static class Solution {
        public long maxPoints(int[][] points) {
            int m = points.length;
            int n = points[0].length;
            long[][] dp = new long[m][n];
            long[] left = new long[n];
            long[] right = new long[n];

            for (int j = 0; j < n; j++) {
                dp[0][j] = points[0][j];
            }

            for (int i = 1; i < m; i++) {
                left[0] = dp[i - 1][0];
                for (int j = 1; j < n; j++) {
                    left[j] = Math.max(left[j - 1] - 1, dp[i - 1][j]);
                }
                right[n - 1] = dp[i - 1][n - 1];
                for (int j = n - 2; j >= 0; j--) {
                    right[j] = Math.max(right[j + 1] - 1, dp[i - 1][j]);
                }

                for (int j = 0; j < n; j++) {
                    dp[i][j] = Math.max(left[j], right[j]) + points[i][j];
                }
            }

            long res = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (dp[m - 1][j] > res) {
                    res = dp[m - 1][j];
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
            sol.maxPoints(
                new int[][]{{1, 2, 3}, {1, 5, 1}, {3, 1, 1}}
            )
        );
    }
}

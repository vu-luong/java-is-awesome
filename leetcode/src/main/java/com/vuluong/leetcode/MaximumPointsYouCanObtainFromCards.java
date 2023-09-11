package com.vuluong.leetcode;

public class MaximumPointsYouCanObtainFromCards {

    public static class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int right = 0, left = 0;
            // select all elements on the right
            for (int i = n - 1; i >= n - k; i--) {
                right += cardPoints[i];
            }
            int res = right;
            for (int i = 0; i < k; i++) { // 0 -> index i on the left
                right = right - cardPoints[n - k + i];
                left += cardPoints[i];
                if (res < right + left) {
                    res = right + left;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
            sol.maxScore(
                new int[]{1, 2, 3, 4, 5, 6, 1}, 3
            )
        );

        System.out.println(
            sol.maxScore(
                new int[]{2, 2, 2}, 2
            )
        );

        System.out.println(
            sol.maxScore(
                new int[]{9, 7, 7, 9, 7, 7, 9}, 7
            )
        );
    }
}

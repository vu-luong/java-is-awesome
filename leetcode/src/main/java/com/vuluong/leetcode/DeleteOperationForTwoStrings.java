package com.vuluong.leetcode;

public class DeleteOperationForTwoStrings {

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 5][word2.length() + 5];

        int maxCommonLength = 0;
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if ((i == 0) || (j == 0)) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = 1;
                    } else {
                        if (i == 0 && j == 0) dp[i][j] = 0;
                        else if (i == 0) dp[i][j] = dp[i][j - 1];
                        else if (j == 0) dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = Math.max(
                            Math.max(dp[i][j - 1], dp[i - 1][j]),
                            dp[i - 1][j - 1] + 1
                        );
                    } else {
                        dp[i][j] = Math.max(
                            Math.max(dp[i][j - 1], dp[i - 1][j]),
                            dp[i - 1][j - 1]
                        );
                    }
                }

                if (dp[i][j] > maxCommonLength) {
                    maxCommonLength = dp[i][j];
                }
            }
        }

        return word1.length() + word2.length() - maxCommonLength * 2;
    }

    public static void main(String[] args) {
        System.out.println(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "unmicroscopically"));
    }
}

package com.vuluong.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    
    public static class Solution {
        public int longestStrChain(String[] words) {
            Map<String, Integer> dp = new HashMap<>();
            Arrays.sort(words, Comparator.comparingInt(String::length));
            
            int res = 0;

            for (String word : words) {
                int cur = 1;
                for (int j = 0; j < word.length(); j++) {
                    String prev = word.substring(0, j) + word.substring(j + 1);
                    cur = Math.max(cur, dp.getOrDefault(prev, 0) + 1);
                }
                dp.put(word, cur);
                res = Math.max(res, dp.get(word));
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
            sol.longestStrChain(
                new String[]{"a", "b", "ba", "bca", "bda", "bdca"}
            )
        );

        System.out.println(
            sol.longestStrChain(
                new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}
            )
        );

        System.out.println(
            sol.longestStrChain(
                new String[]{"abcd", "dbqca"}
            )
        );
    }
}

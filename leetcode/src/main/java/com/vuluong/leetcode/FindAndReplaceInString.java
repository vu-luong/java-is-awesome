package com.vuluong.leetcode;

import java.util.Arrays;

public class FindAndReplaceInString {
    public static class Solution {
        public String findReplaceString(
            String s, int[] indices, String[] sources, String[] targets
        ) {
            int k = indices.length;
            int n = s.length();
            int[] mark = new int[n];
            Arrays.fill(mark, -1);
            
            for (int i = 0; i < k; i++) {
                int index = indices[i];
                String source = sources[i];
                if (s.startsWith(source, index)) {
                    mark[index] = i;
                }
            }
            
            StringBuilder res = new StringBuilder();
            int i = 0;
            while (i < n) {
                if (mark[i] != -1) {
                    res.append(targets[mark[i]]);
                    i = i + sources[mark[i]].length();
                } else {
                    res.append(s.charAt(i));
                    i += 1;
                }
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findReplaceString(
            "abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}
        ));
    }
}

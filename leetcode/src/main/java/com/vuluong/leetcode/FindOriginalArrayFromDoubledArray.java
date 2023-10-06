package com.vuluong.leetcode;

import java.util.Arrays;

public class FindOriginalArrayFromDoubledArray {

    public static class Solution {
        public int[] findOriginalArray(int[] changed) {

            Arrays.sort(changed);

            int n = changed.length;

            for (int i = n - 1; i >= 0; i--) {
                System.out.println(changed[i] + "");
            }
            
            return null;
        }
    }

    public static void main(String[] args) {
        new Solution().findOriginalArray(new int[]{1, 3, 4, 2, 6, 8});
    }

}

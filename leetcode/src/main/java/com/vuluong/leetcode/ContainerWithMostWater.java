package com.vuluong.leetcode;

public class ContainerWithMostWater {

    static class Solution {
        public int maxArea(int[] height) {
            int leftIndex = 0;
            int rightIndex = height.length - 1;
            int answer = 0;
            while (leftIndex < rightIndex) {
                int currentArea = Math.min(height[leftIndex], height[rightIndex])
                    * (rightIndex - leftIndex);
                if (currentArea > answer) {
                    answer = currentArea;
                }
                if (height[leftIndex] < height[rightIndex]) {
                    leftIndex += 1;
                } else {
                    rightIndex -= 1;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

}

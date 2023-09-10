package com.vuluong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {

    public static class Solution {

        public static class Point {
            private final int x;
            private final int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Point point = (Point) o;

                if (x != point.x) return false;
                return y == point.y;
            }

            @Override
            public int hashCode() {
                int result = x;
                result = 31 * result + y;
                return result;
            }
        }

        public int minAreaRect(int[][] points) {
            int nPoints = points.length;
            Set<Point> set = new HashSet<>();

            for (int[] point : points) {
                set.add(new Point(point[0], point[1]));
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nPoints - 1; i++) {
                for (int j = i + 1; j < nPoints; j++) {
                    int xi = points[i][0];
                    int yi = points[i][1];
                    int xj = points[j][0];
                    int yj = points[j][1];
                    
                    if (xi == xj || yi == yj) {
                        continue;
                    }

                    if (set.contains(new Point(xi, yj)) && set.contains(new Point(xj, yi))) {
                        int area = Math.abs(xi - xj) * Math.abs(yi - yj);
                        if (area < res) {
                            res = area;
                        }
                    }
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
            sol.minAreaRect(
                new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}}
            )
        );
    }
}

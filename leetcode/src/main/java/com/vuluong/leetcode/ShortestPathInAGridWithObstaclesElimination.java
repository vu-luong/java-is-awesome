package com.vuluong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {

    static class State {
        private int x, y, e, cost;

        public State(int x, int y, int e, int cost) {
            this.x = x;
            this.y = y;
            this.e = e;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getE() {
            return e;
        }

        public void setE(int e) {
            this.e = e;
        }
    }

    static class Solution {
        public int shortestPath(int[][] grid, int k) {
            final int MAXN = 41;
            int M = grid.length;
            int N = grid[0].length;
            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};
            Queue<State> queue = new LinkedList<>();
            boolean[][][] visited = new boolean[MAXN][MAXN][MAXN * MAXN];
            State initialState = new State(0, 0, 0, 0);
            if (checkGoal(initialState, M, N)) {
                return 0;
            }
            queue.offer(initialState);
            visited[0][0][0] = false;

            while (!queue.isEmpty()) {
                State currentState = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = currentState.getX() + dx[i];
                    int newY = currentState.getY() + dy[i];

                    if (newX >= 0 && newX < M && newY >= 0 && newY < N) {
                        if (grid[newX][newY] == 0) {
                            if (!visited[newX][newY][currentState.getE()]) {
                                State newState = new State(
                                    newX, newY, currentState.getE(), currentState.getCost() + 1
                                );
                                if (checkGoal(newState, M, N)) {
                                    return newState.getCost();
                                }
                                queue.offer(newState);
                                visited[newX][newY][currentState.getE()] = true;
                            }
                        } else {
                            if (currentState.getE() < k) {
                                if (!visited[newX][newY][currentState.getE() + 1]) {
                                    State newState = new State(
                                        newX, newY, currentState.getE() + 1, currentState.getCost() + 1
                                    );
                                    if (checkGoal(newState, M, N)) {
                                        return newState.getCost();
                                    }
                                    queue.offer(newState);
                                    visited[newX][newY][currentState.getE() + 1] = true;
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private boolean checkGoal(State newState, int M, int N) {
            if (newState.getX() == M - 1 && newState.getY() == N - 1) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
            new int[]{0, 0, 0},
            new int[]{1, 1, 0},
            new int[]{0, 0, 0},
            new int[]{0, 1, 1},
            new int[]{0, 0, 0},
        };
        System.out.println(new Solution().shortestPath(grid, 1));
    }
}

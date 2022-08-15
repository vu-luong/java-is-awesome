package com.vuluong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    public int maxLevel = -1;
    public List<Integer> ans = new ArrayList<>();

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level > maxLevel) {
            ans.add(node.val);
        } else {
            if (node.val > ans.get(level)) {
                ans.set(level, node.val);
            }
        }

        if (level > maxLevel) {
            maxLevel = level;
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

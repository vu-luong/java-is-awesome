package com.vuluong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicateSubtrees {

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

    public static class Solution {
        private final List<TreeNode> res = new ArrayList<>();
        private final Map<String, Integer> idBySerial = new HashMap<>();
        private final Map<Integer, Integer> countBySerialId = new HashMap<>();
        private int curSerialId = 1;
        
        public int dfs(TreeNode node) {
            if (node == null) return 0;
            
            boolean isLeaf = (node.left == null) && (node.right == null);
            String serial = "";
            
            // can construct the serial by using in-order traversal instead
            if (node.left != null) {
                serial = serial + dfs(node.left) + "-l;";
            }
            if (node.right != null) {
                serial = serial + dfs(node.right) + "-r;";
            }
            if (isLeaf) {
                serial = serial + node.val + "-1";
            } else {
                serial = serial + node.val + "-0";
            }
            
            int serialId = idBySerial.getOrDefault(serial, curSerialId);
            if (serialId == curSerialId) {
                curSerialId++;
            }
            idBySerial.put(serial, serialId);
            int curCount = countBySerialId.getOrDefault(serialId, 0);
            if (curCount == 1) {
                res.add(node);
            }
            countBySerialId.put(serialId, curCount + 1);
            return serialId;
        }

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            System.out.println(dfs(root));
            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2, n1, null);
        TreeNode n4 = new TreeNode(2, n2, null);
        TreeNode root = new TreeNode(2, n3, n4);
        
        Solution sol = new Solution();
        
        System.out.println(
            sol.findDuplicateSubtrees(root)
                .stream()
                .map(node -> node.val + "")
                .collect(Collectors.joining(", "))
        );
    }
}

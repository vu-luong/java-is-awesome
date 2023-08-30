package com.vuluong.leetcode;

import java.util.Stack;

public class DecodeString {

    static class Solution {
        public String decodeString(String s) {
            Stack<String> stack = new Stack<>();
            StringBuilder currentNumber = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    currentNumber.append(c);
                } else if (c == '[') {
                    stack.push(currentNumber.toString());
                    stack.push("[");
                    currentNumber = new StringBuilder();
                } else if (c == ']') {
                    StringBuilder sb = new StringBuilder();
                    while (!stack.peek().equals("[")) {
                        sb.insert(0, stack.pop());
                    }
                    stack.pop(); // "["
                    int number = Integer.parseInt(stack.pop());
                    StringBuilder multiBuilder = new StringBuilder();
                    for (int j = 0; j < number; j++) {
                        multiBuilder.append(sb);
                    }
                    stack.push(multiBuilder.toString());
                } else {
                    stack.push(c + "");
                }
            }

            StringBuilder res = new StringBuilder();
            while (!stack.isEmpty()) {
                res.insert(0, stack.pop());
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
    }
}

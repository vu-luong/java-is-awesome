package com.vuluong.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static class Solution {
        
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                switch (token) {
                    case "+": {
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num1 + num2);
                        break;
                    }
                    case "-": {
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num2 - num1);
                        break;
                    }
                    case "*": {
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num2 * num1);
                        break;
                    }
                    case "/": {
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num2 / num1);
                        break;
                    }
                    default:
                        int num = Integer.parseInt(token);
                        stack.push(num);
                        break;
                }
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
            sol.evalRPN(
                new String[]{"2", "1", "+", "3", "*"}
            )
        );

        System.out.println(
            sol.evalRPN(
                new String[]{"4", "13", "5", "/", "+"}
            )
        );

        System.out.println(
            sol.evalRPN(
                new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}
            )
        );
    }
}

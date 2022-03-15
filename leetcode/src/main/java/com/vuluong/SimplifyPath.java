package com.vuluong;

import java.util.Stack;

public class SimplifyPath {
    static class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();
            String[] list = path.split("/");
            
            for (String s : list) {
                if (s.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!s.equals(".") && !s.equals("/") && !s.equals("")) {
                    stack.push(s);
                }
            }
            
            StringBuilder answer = new StringBuilder();
            while (!stack.isEmpty()) {
                answer.insert(0, "/" + stack.pop());
            }
            return answer.toString().equals("") ? "/" : answer.toString();
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home/"));
    }
}


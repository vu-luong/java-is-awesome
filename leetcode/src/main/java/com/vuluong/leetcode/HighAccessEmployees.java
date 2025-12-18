package com.vuluong.leetcode;

import java.util.*;

public class HighAccessEmployees {

    static class Solution {

        public List<String> findHighAccessEmployees(List<List<String>> access_times) {

            Map<String, List<Integer>> timestampsByName = new HashMap<>();

            for (List<String> accessTime : access_times) {
                String name = accessTime.get(0);
                String time = accessTime.get(1);

                int hour = Integer.parseInt(time.substring(0, 2));
                int min = Integer.parseInt(time.substring(2, 4));
                int timestamp = hour * 60 + min;
                timestampsByName.computeIfAbsent(
                    name, s -> new ArrayList<>()
                ).add(timestamp);
            }

            List<String> res = new ArrayList<>();
            for (String name : timestampsByName.keySet()) {
                List<Integer> timestamps = timestampsByName.get(name);
                timestamps.sort(Integer::compareTo);

                int prev = 0;
                for (int i = 1; i < timestamps.size(); i++) {
                    int timestamp = timestamps.get(i);
                    while (timestamp - timestamps.get(prev) >= 60) {
                        prev += 1;
                    }
                    if (i - prev + 1 >= 3) {
                        res.add(name);
                        break;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        List<List<String>> accessTimes = Arrays.asList(
//            Arrays.asList("a", "0549"),
//            Arrays.asList("b", "0457"),
//            Arrays.asList("a", "0532"),
//            Arrays.asList("a", "0621"),
//            Arrays.asList("b", "0540")
//        );
//        List<List<String>> accessTimes = Arrays.asList(
//            Arrays.asList("d", "0002"),
//            Arrays.asList("c", "0808"),
//            Arrays.asList("c", "0829"),
//            Arrays.asList("e", "0215"),
//            Arrays.asList("d", "1508"),
//            Arrays.asList("d", "1444"),
//            Arrays.asList("d", "1410"),
//            Arrays.asList("c", "0809")
//        );
        List<List<String>> accessTimes = Arrays.asList(
            Arrays.asList("cd", "1025"),
            Arrays.asList("ab", "1025"),
            Arrays.asList("cd", "1046"),
            Arrays.asList("cd", "1055"),
            Arrays.asList("ab", "1124"),
            Arrays.asList("ab", "1120")
        );
        System.out.println(sol.findHighAccessEmployees(accessTimes));
    }
}

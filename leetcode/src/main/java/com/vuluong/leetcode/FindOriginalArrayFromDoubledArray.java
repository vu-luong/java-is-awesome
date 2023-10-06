package com.vuluong.leetcode;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOriginalArrayFromDoubledArray {

    public static class Solution {
        public int[] findOriginalArray(int[] changed) {
            if (changed.length % 2 != 0) {
                return new int[0];
            }
            Arrays.sort(changed);
            int n = changed.length;
            Map<Integer,Integer> map = new HashMap<>();

            for (int i = n - 1; i >= 0; i--) {
                map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
            }

            int[] res = new int[n / 2];
            int cnt = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (map.get(changed[i]) > 0 && changed[i] % 2 == 0) {
                    map.put(changed[i], map.get(changed[i]) - 1);
                    if (map.getOrDefault(changed[i] / 2, 0) > 0) {
                        map.put(changed[i] / 2, map.get(changed[i] / 2) - 1);
                        cnt += 1;
                        res[cnt] = changed[i] / 2;
                    }
                }
            }

            if ((cnt + 1) != n / 2) {
                return new int[0];
            }

            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(new Solution().findOriginalArray(new int[]{1, 3, 4, 2, 6, 8}))
        );
        
        System.out.println(
            Arrays.toString(new Solution().findOriginalArray(new int[]{6,3,0,1}))
        );
        
        System.out.println(
            Arrays.toString(new Solution().findOriginalArray(new int[]{0, 0, 0, 0}))
        );
    }

}

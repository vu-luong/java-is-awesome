package com.vuluong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickWithWeight {
    List<Integer> prefixSum = new ArrayList<>();
    int sum = 0;

    public RandomPickWithWeight(int[] w) {
        prefixSum.add(0);
        for (int wi : w) {
            sum += wi;
            prefixSum.add(sum);
        }
        System.out.println(prefixSum);
    }

    public int binarySearch(int number) {
        int left = 0;
        int right = prefixSum.size() - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (number >= prefixSum.get(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int pickIndex() {
        Random r = new Random();
        int number = r.nextInt(sum);
        return binarySearch(number);
    }
}
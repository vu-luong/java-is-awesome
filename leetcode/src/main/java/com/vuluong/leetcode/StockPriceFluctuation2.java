package com.vuluong.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

class StockPriceFluctuation2 {
    static class StockPrice {

        private final TreeMap<Integer, Integer> priceByTimestamp = new TreeMap<>();
        private final TreeMap<Integer, Set<Integer>> timestampsByPrice = new TreeMap<>();

        public StockPrice() {
        }

        public void update(int timestamp, int price) {
            if (priceByTimestamp.containsKey(timestamp)) {
                int prevPrice = priceByTimestamp.get(timestamp);
                timestampsByPrice.get(prevPrice).remove(timestamp);
                if (timestampsByPrice.get(prevPrice).isEmpty()) {
                    timestampsByPrice.remove(prevPrice);
                }
            }
            priceByTimestamp.put(timestamp, price);
            timestampsByPrice.putIfAbsent(price, new HashSet<>());
            timestampsByPrice.get(price).add(timestamp);
        }

        public int current() {
            return priceByTimestamp.lastEntry().getValue();
        }

        public int maximum() {
            return timestampsByPrice.lastKey();
        }

        public int minimum() {
            return timestampsByPrice.firstKey();
        }
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
        stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
        System.out.println(stockPrice.current());     // return 5, the latest timestamp is 2 with the price being 5.
        System.out.println(stockPrice.maximum());     // return 10, the maximum price is 10 at timestamp 1.
        stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
        // Timestamps are [1,2] with corresponding prices [3,5].
        System.out.println(stockPrice.maximum());     // return 5, the maximum price is 5 after the correction.
        stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
        System.out.println(stockPrice.minimum());     // return 2, the minimum price is 2 at timestamp 4.
    }
}

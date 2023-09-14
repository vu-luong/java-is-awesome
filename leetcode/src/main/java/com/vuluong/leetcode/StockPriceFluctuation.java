package com.vuluong.leetcode;

import java.util.TreeMap;

public class StockPriceFluctuation {

    public static class StockPrice {
        
        public static class Pair {
            int x, y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Pair pair = (Pair) o;

                if (x != pair.x) return false;
                return y == pair.y;
            }

            @Override
            public int hashCode() {
                int result = x;
                result = 31 * result + y;
                return result;
            }
        }

        private final TreeMap<Integer, Integer> treeMap;
        private final TreeMap<Pair, Integer> treeMap2;
        
        public StockPrice() {
            treeMap = new TreeMap<>(); 
            treeMap2 = new TreeMap<>((p1, p2) -> (p1.y != p2.y) ? (Integer.compare(p1.y, p2.y)) : (Integer.compare(p1.x, p2.x)));
        }

        public void update(int timestamp, int price) {
            if (treeMap.containsKey(timestamp)) {
                Integer oldPrice = treeMap.get(timestamp);
                treeMap2.remove(new Pair(timestamp, oldPrice));
            }
            treeMap2.put(new Pair(timestamp, price), price);
            treeMap.put(timestamp, price);
        }

        public int current() {
            return treeMap.lastEntry().getValue();
        }

        public int maximum() {
            return treeMap2.lastEntry().getValue();
        }

        public int minimum() {
            return treeMap2.firstEntry().getValue();
        }
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        System.out.println(stockPrice.minimum());
        stockPrice.update(1, 3);
        
        System.out.println(stockPrice.maximum());
        stockPrice.update(4, 2);
        System.out.println(stockPrice.minimum());
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
    }

}

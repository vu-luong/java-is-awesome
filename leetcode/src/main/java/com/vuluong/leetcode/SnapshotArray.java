package com.vuluong.leetcode;

import java.util.*;

public class SnapshotArray {

    List<TreeMap<Integer, Integer>> list;
    int curSnap;
    
    public SnapshotArray(int length) {
        list = new ArrayList<>();
        curSnap = 0;
        for (int i = 0; i < length; i++) {
            list.add(new TreeMap<>());
            list.get(i).put(0, 0);
        }
    }

    public void set(int index, int val) {
        list.get(index).put(curSnap, val);
    }

    public int snap() {
        curSnap += 1;
        return curSnap - 1;
    }

    public int get(int index, int snap_id) {
        return list.get(index).floorEntry(snap_id).getValue();
    }

    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(1);
        snapshotArr.set(0, 15);
        System.out.println(snapshotArr.snap());
        System.out.println(snapshotArr.snap());
        System.out.println(snapshotArr.snap());
        System.out.println(snapshotArr.get(0, 2));
    }
}

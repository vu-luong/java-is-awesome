package datastructure;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;


@Data
@AllArgsConstructor
class A {
	int id;
}

public class TreeMapVsHashMapExample {
	
	public static void main(String[] args) {
		nextOfComparision();
	}
	
	private static void nextOfComparision() {
		Random random = new Random(123);
		TreeMap<Integer, A> treeMap = new TreeMap<>();
		HashMap<Integer, A> hashMap = new HashMap<>();
		List<Integer> locations1 = new ArrayList<>();
		List<Integer> locations2 = new ArrayList<>();
		int N = 10;
		System.out.println("N = " + N);
		int location = 0;
		for (int i = 0; i < N; ++i) {
			int gap = random.nextInt(10);
			location += gap;
			locations1.add(location);
			locations2.add(location);
			A item = new A(i);
			treeMap.put(location, item);
			hashMap.put(location, item);
		}
		
		System.out.println(treeMap);
		System.out.println(treeMap.lowerEntry(2));
		
		Collections.shuffle(locations1);
		
		// Test TreeMap
		long start = System.currentTimeMillis();
		for (int i = 0; i < N; ++i) {
			Integer curLocation = locations1.get(i);
			Integer neighbor = nextOf(treeMap, curLocation);
			treeMap.remove(curLocation);
//			System.out.println("nextOf(" + curLocation + ") = " + neighbor);
//			System.out.println(treeMap.toString());
		}
		long end = System.currentTimeMillis();
		System.out.println("TreeMap running Time: " + (end - start));
		
		// Test HashMap
		start = System.currentTimeMillis();
		for (int i = 0; i < N; ++i) {
			Integer curLocation = locations1.get(i);
			Integer neighbor = nextOf(hashMap, curLocation, locations2);
			hashMap.remove(curLocation);
			locations2.remove(curLocation);
//			System.out.println("nextOf(" + curLocation + ") = " + neighbor);
//			System.out.println(hashMap.toString());
		}
		end = System.currentTimeMillis();
		System.out.println("HashMap running Time: " + (end - start));
	}
	
	private static Integer nextOf(TreeMap<Integer, A> treeMap, Integer key) {
		Integer prevKey = treeMap.lowerKey(key);
		Integer nextKey = treeMap.higherKey(key);
		
		if (prevKey == null) {
			return nextKey;
		}
		if (nextKey == null) {
			return prevKey;
		}
		
		return (key - prevKey) < (nextKey - key) ? prevKey : nextKey;
	}
	
	private static Integer nextOf(HashMap<Integer, A> hashMap, Integer key, List<Integer> locations) {
		
		int minDistance = Integer.MAX_VALUE;
		Integer answer = null;
		
		for (Integer location : locations) {
			if (location.equals(key)) continue;
			if (Math.abs(location - key) < minDistance) {
				minDistance = Math.abs(location - key);
				answer = location;
			}
		}
		
		return answer;
	}
}

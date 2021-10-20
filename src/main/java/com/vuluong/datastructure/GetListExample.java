package com.vuluong.datastructure;

import java.util.ArrayList;
import java.util.List;

class ReadOnlyList<E> {
	
	private final List<E> list;
	
	public ReadOnlyList(List<E> list) {
		this.list = list;
	}
	
	public E get(int id) {
		return list.get(id);
	}
	
	public int size() {
		return list.size();
	}
}

class Data {
	private List<Integer> list = new ArrayList<>();
	
	public Data(int M) {
		for (int i = 0; i < M; ++i) {
			list.add(i);
		}
	}
	
	public ReadOnlyList<Integer> getList() {
		return new ReadOnlyList<>(list);
	}
	
	public void getList(List<Integer> buffer) {
		buffer.addAll(list);
	}
}

public class GetListExample {
	
	public static void main(String[] args) {
		int M = 10000;
		int N = 100000;
		System.out.println("M = " + M);
		System.out.println("N = " + N);
		Data data = new Data(M);
		List<Integer> buffer = new ArrayList<>();
		
		long start = System.currentTimeMillis();
		long count = 0;
		for (int i = 0; i < N; ++i) {
			buffer.clear();
			data.getList(buffer);
			for (Integer item : buffer) {
				count += item;
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Count = " + count);
		System.out.println("Copy List time: " + (end - start));
		
		
		start = System.currentTimeMillis();
		count = 0;
		for (int i = 0; i < N; ++i) {
			ReadOnlyList<Integer> readOnlyList = data.getList();
			
			for (int j = 0; j < readOnlyList.size(); j++) {
				Integer item = readOnlyList.get(j);
				count += item;
			}
		}
		
		end = System.currentTimeMillis();
		System.out.println("Count = " + count);
		System.out.println("Read Only List time: " + (end - start));
	}
}

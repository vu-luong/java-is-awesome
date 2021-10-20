package com.vuluong.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ReadOnlyList<E> implements Iterable<E> {
	
	private final List<E> list;
	
	public ReadOnlyList(List<E> list) {
		this.list = list;
	}
	
	public E get(int id) {
		return list.get(id);
	}
	
	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}
}

class Data {
	private List<Integer> list = new ArrayList<>();
	
	public Data(int M) {
		for (int i = 0; i < M; i++) {
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
		Data data = new Data(M);
		List<Integer> buffer = new ArrayList<>();
		
		long start = System.currentTimeMillis();
		long count = 0;
		for (int i = 0; i < N; i++) {
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
		for (int i = 0; i < N; i++) {
			ReadOnlyList<Integer> readOnlyList = data.getList();
			
			for (Integer item : readOnlyList) {
				count += item;
			}
		}
		
		end = System.currentTimeMillis();
		System.out.println("Count = " + count);
		System.out.println("Read Only List time: " + (end - start));
	}
	
}

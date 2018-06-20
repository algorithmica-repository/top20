package com.alg.top20.ds;

import java.util.TreeMap;

public class MyCalender {
	private TreeMap<Integer, Integer> map;
	
	public MyCalender() {
		map = new TreeMap<Integer, Integer>();
	}
	
	public boolean book(int start, int end) {
		Integer prev = map.floorKey(start);
		Integer next = map.ceilingKey(start);
		if(prev != null && start < map.get(prev))
			return false;
		if(next != null && end > next)
			return false;
		map.put(start, end);
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

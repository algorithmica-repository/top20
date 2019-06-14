package com.alg.top20.sorted;

import java.util.TreeMap;

public class MyCalender {
	private TreeMap<Integer, Integer> events;
	
	public MyCalender() {
		events = new TreeMap<Integer, Integer>();
	}
	public boolean book(int start, int end) {
		if(events.size() == 0) {
			events.put(start, end);
			return true;
		}
		Integer floorkey = events.floorKey(start);
		if(floorkey != null && events.get(floorkey) > start) return false;
		Integer ceilkey = events.ceilingKey(start);
		if(ceilkey != null && ceilkey < end) return false;
		events.put(start, end);
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

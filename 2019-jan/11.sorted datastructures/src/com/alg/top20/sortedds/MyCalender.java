package com.alg.top20.sortedds;

import java.util.TreeMap;

public class MyCalender {
	private TreeMap<Integer, Integer> events_map;
	
	public MyCalender() {
		events_map = new TreeMap<Integer, Integer>();
	}
	public boolean book(int start, int end) {
		if(events_map.size() == 0)  {
			events_map.put(start, end);
			return true;
		}
		Integer key = events_map.floorKey(start);
		if(key != null && events_map.get(key) >= start) return false;
		key = events_map.ceilingKey(start);
		if(key != null && key <= end) return false;
		events_map.put(start, end);
		return true;		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

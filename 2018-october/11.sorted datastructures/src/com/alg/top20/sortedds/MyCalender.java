package com.alg.top20.sortedds;

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
		if(floorkey != null) {
			Integer floorval = events.get(floorkey);
			if(start < floorval)	return false;
		}
		Integer ceilkey = events.ceilingKey(start);
		if(ceilkey != null) {
			//Integer ceilval = events.get(ceilkey);
			if(end > ceilkey) return false;
		}
		events.put(start, end);
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

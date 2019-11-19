package com.alg.top20.sortedds;

import java.util.TreeMap;

public class MyCalender2 {
	private TreeMap<Integer, Integer> events = new TreeMap<Integer, Integer>();

	public boolean book(int start, int end) {
		Integer floorStart = events.floorKey(start);
		if (floorStart != null && events.get(floorStart) > start)
			return false;

		Integer ceilStart = events.ceilingKey(start);
		if (ceilStart != null && ceilStart < end)
			return false;

		events.put(start, end);
		return true;
	}

}

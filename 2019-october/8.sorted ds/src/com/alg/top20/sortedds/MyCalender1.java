package com.alg.top20.sortedds;

import java.util.ArrayList;
import java.util.List;

class Event {
	int start;
	int end;

	public Event(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

}

public class MyCalender1 {
	private List<Event> events = new ArrayList<Event>();

	public boolean book(int start, int end) {
		for (Event event : events) {
			if (!(event.end < start || event.start >= end) ) {
				return false;
			}
		}
		events.add(new Event(start, end));
		return true;
	}

	

}

package com.alg.top20.cache;

import java.util.HashMap;

public class LinkedMapCache implements ICache {
	
	class ListNode {
		Integer key;
		String value;
		ListNode next;
		ListNode prev;
		ListNode() {
			next = prev = this;
		}
		public ListNode(Integer key, String value) {
			super();
			this.key = key;
			this.value = value;
		}		
	}
	private HashMap<Integer, ListNode>  map;
	private ListNode head;
	private int size;
	private int capacity;
	
	public LinkedMapCache(int capacity) {
		head = new ListNode();
		map = new HashMap<Integer, ListNode>();
		this.capacity = capacity;
		size = 0;
	}
	
	@Override
	public void add(Integer key, String value) {
		if(map.containsKey(key)) {
			ListNode tmp  = map.get(key);
			tmp.value = value;
			manageLRU(tmp);
			return;
		}
		if(size == capacity) {
			ListNode first = head.next;
			first.next.prev = head;
			head.next = first.next;	
			map.remove(first.key);
		} else
			++size;
		ListNode tmp  = new ListNode(key,value);
		head.prev.next = tmp;
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev = tmp;
		map.put(key, tmp);
		
	}
	
	private void manageLRU(ListNode tmp) {
		tmp.next.prev = tmp.prev;
		tmp.prev.next = tmp.next;
		head.prev.next = tmp;
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev = tmp;
	}
	@Override
	public String get(Integer key) {
		if(map.containsKey(key)) {
			ListNode tmp = map.get(key);
			manageLRU(tmp);	
			return tmp.value;
		}
		else 
			return null;
	}
	@Override
	public void display() {
		ListNode  current = head.next;
		for(;current != head; current = current.next) {
			System.out.print("(" + current.key + "," + current.value + ") ");
		}
		System.out.println();
	}
	
	

}









package com.alg.top20.cache;

import java.util.HashMap;

public class LinkedHashCache implements ICache {
	private HashMap<String, DListNode> index;
	private DoublyLinkedList list;
	private int capacity;
	
	public LinkedHashCache(int capacity) {
		index = new HashMap<String, DListNode>();
		list = new DoublyLinkedList();
		this.capacity = capacity;
	}
	
	//O(1)
	@Override
	public Integer get(String key) {
		//retrieve list node from index
		DListNode tmp  = index.get(key);
		Integer res = null;
		if(tmp != null) {
			res = tmp.value;
			//keep most recently accessed element at the end
			list.removeAddLast(tmp);
		}
		return res;
	}

	@Override
	public void put(String key, Integer value) {
		DListNode tmp = index.get(key);
		//if key already exists, replace the old value with new value
		if(tmp != null) {
			tmp.value = value;
			list.removeAddLast(tmp);
		} else {
			//key does not exist, add the new element to cache
			if(isFull()) {
				DListNode lru = list.removeFirst();
				index.remove(lru.key);
			}
			DListNode last = list.addLast(key, value);
			index.put(key, last);
		}

	}

	private boolean isFull() {
		return capacity == list.size();
	}
	@Override
	public void display() {
		list.display();
	}

}

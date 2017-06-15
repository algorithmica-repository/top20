package com.alg.top20.cache;

import java.util.HashMap;

public class LinkedHashCache implements ICache {
	private HashMap<String, DListNode> index;
	private DoublyLinkedList list;
	private int size;
	
	public LinkedHashCache(int size) {
		index = new HashMap<String, DListNode>();
		list = new DoublyLinkedList();
		this.size = size;
	}
	
	//O(1)
	@Override
	public Integer get(String key) {
		DListNode tmp  = index.get(key);
		Integer res = null;
		if(tmp != null) {
			res = tmp.value;
			list.removeAddLast(tmp);
		}
		return res;
	}

	@Override
	public void put(String key, Integer value) {
		DListNode tmp = index.get(key);
		if(tmp != null) {
			tmp.value = value;
			list.removeAddLast(tmp);
		} else {
			if(isFull()) {
				DListNode lru = list.removeFirst();
				index.remove(lru.key);
			}
			DListNode last = list.addLast(key, value);
			index.put(key, last);
		}

	}

	private boolean isFull() {
		return true;
	}
	@Override
	public void display() {
		list.display();
	}

}

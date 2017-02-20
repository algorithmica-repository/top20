package com.alg.top20.cache;

import java.util.HashMap;

public class LinkedHashMapCache implements ICache {
	private DoublyLinkedList list;
	private HashMap<String, DListNode> index;
	private int capacity;
	
	public LinkedHashMapCache(int capacity) {
		this.capacity = capacity;
		index = new HashMap<String, DListNode>();
		list = new DoublyLinkedList(); 
	}
	//O(1)
	public Integer get(String key) {
		DListNode tmp = index.get(key);
		if(tmp == null) return null;
		//manage LRU by brining current node to last index
		list.removeAndAdd(tmp);
		return tmp.value;
	}
	
	private boolean isFull() {
		return list.size() == capacity;
	}

	//O(1)
	public void add(String key, Integer value) {
		DListNode tmp = index.get(key);
		//replace value if key exists in cache
		if(tmp != null) {
			tmp.value = value;
			list.removeAndAdd(tmp);
		}
		else {
			//remove LRU element if cache is full
			if(isFull()) {
				tmp = list.removeFirst();
				index.remove(tmp.key);
			}
			tmp = list.addLast(key, value);
			index.put(key, tmp);
		}
		
	}

	@Override
	public void display() {
		list.display();		
	}

	@Override
	public int capacity() {
		return capacity;
	}

	@Override
	public int size() {
		return list.size();
	}

}

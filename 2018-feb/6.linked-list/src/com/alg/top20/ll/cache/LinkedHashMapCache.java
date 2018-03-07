package com.alg.top20.ll.cache;

import java.util.HashMap;

public class LinkedHashMapCache implements ICache{
	private HashMap<String, DListNode> index;
	private DoublyLinkedList list;
	private int capacity;
	
	public LinkedHashMapCache(int capacity) {
		list = new DoublyLinkedList();
		index = new HashMap<String, DListNode>();
		this.capacity = capacity;
	}
	@Override
	public Integer get(String key) {
		DListNode tmp;
		tmp = index.get(key);
		if(tmp == null) return null;
		list.moveToEnd(tmp);
		return tmp.value;
	}

	@Override
	public void put(String key, Integer value) {
		DListNode tmp;
		if(index.containsKey(key)) {
			tmp = index.get(key);
			tmp.value = value;
			list.moveToEnd(tmp);
		} else {
			if(list.size() < capacity) {
				tmp = list.addEnd(key, value);
				index.put(key, tmp);
			} else {
				list.removeFirst();
				tmp = list.addEnd(key, value);
				index.put(key, tmp);
			}
		}
	}
	
	public void display() {
		list.display();
	}

}

package com.alg.top20.cache;

import java.util.HashMap;

public class LinkedHashCache implements ICache {
	private int capacity;
	private int size;
	private DLinkedList list;
	private HashMap<String, DListNode> index;
	
	public LinkedHashCache(int capacity) {
		this.capacity = capacity;
		list = new DLinkedList();
		index = new HashMap<String, DListNode>();
	}

	private boolean isCacheFull() {
		return size == capacity;
	}
	
	//O(1)
	@Override
	public void put(String key, Integer value) {
		if(index.containsKey(key)) {
			DListNode node = index.get(key);
			node.value = value;
			list.removeAndAdd(node);
			return;
		}
		if(isCacheFull()) {
			DListNode lru = list.removeFirst();
			index.remove(lru.key);
			--size;
		} 

		DListNode node = list.addLast(key, value);
		index.put(key, node);
		++size;
	}

	//O(1)
	@Override
	public Integer get(String key) {
		//find the node address from index - O(1)
		DListNode node = index.get(key);
		if(node == null) return null;
		//remove and add at last inside list- O(1)
		list.removeAndAdd(node);
		return node.value;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	@Override
	public void display() {
		list.print();

	}

}

package com.alg.top20.dsdesign.cache;
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
	public Integer get(String key) {
		DListNode node = index.get(key);
		if(node == null) return null;
		list.removeAddLast(node);
		return node.value;
	}

	//O(1)
	public void add(String key, Integer value) {
		//check if key already exists
		DListNode node = index.get(key);
		if(node != null) {
			node.value = value;
			list.removeAddLast(node);
			return;
		}
		//is the cache full?
		if(capacity == list.size()) {
			DListNode tmp = list.removeFirst();
			index.remove(tmp.key);
		}
		//add the key-value to list and index
		node = list.addLast(key, value);
		index.put(key, node);		
	}

	@Override
	public void display() {
		list.display();		
	}

}

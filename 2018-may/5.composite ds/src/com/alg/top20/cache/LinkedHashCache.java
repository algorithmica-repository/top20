package com.alg.top20.cache;
import java.util.HashMap;


public class LinkedHashCache {
	private HashMap<String, DListNode> index;
	private DoublyLinkedList list;
	private int capacity;
	
	public LinkedHashCache(int capacity) {
		this.capacity = capacity;
		index = new HashMap<String, DListNode>();
		list  = new DoublyLinkedList();
	}
	public Integer get(String key) {
		DListNode node = index.get(key);
		if(node == null) return null;
		list.removeAddEnd(node);
		return node.value;
	}
	
	public void put(String key, Integer value) {
		//check for duplicate key
		DListNode node = index.get(key);
		if(node != null) { 
			node.value = value;
			list.removeAddEnd(node);
			return;
		}
		//check cache is full or not
		if(list.size() == capacity) {
			String tmp = list.removeFirst();
			index.remove(tmp);
		}
		node = list.addEnd(key, value);
		index.put(key, node);		
	}
	
	public void display() {
		list.display();
	}

}

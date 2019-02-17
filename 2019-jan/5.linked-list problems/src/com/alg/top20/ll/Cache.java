package com.alg.top20.ll;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class Cache {
	private DoublyLinkedList list;
	private HashMap<Integer, DListNode> index;
	private int capacity;

	public Cache(int capacity) {
		list = new DoublyLinkedList();
		index = new HashMap<Integer, DListNode>();
		this.capacity = capacity;
	}

	private boolean isFull() {
		return list.size() == capacity;
	}

	public void put(Integer key, String value) {
		DListNode p = index.get(key);
		// key already exists
		if (p != null) {
			p.value = value;
			list.removeAddLast(p);
		} else { // new pair
			// is cache full
			if (isFull()) {
				DListNode tmp = list.removeFirst();
				index.remove(tmp.key);
			}
			DListNode tmp = list.addLast(key, value);
			index.put(key, tmp);
		}
	}

	public String get(Integer key) {
		DListNode p = index.get(key);
		if (p == null)
			return null;
		list.removeAddLast(p);
		return p.value;
	}

	public void display() {
		list.display();
	}
	public static void main(String[] args) {
		Cache cache = new Cache(3);
		Random r = new Random(100);
		for(int i = 0; i < 10; ++i) {
			cache.put(r.nextInt(100)+1, UUID.randomUUID().toString());
			cache.display();
			if(i == 2) {  
				cache.get(51);
				cache.display();
			}
		}

	}

}

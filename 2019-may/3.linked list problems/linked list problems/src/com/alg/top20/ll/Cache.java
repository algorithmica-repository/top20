package com.alg.top20.ll;

import java.util.HashMap;
import java.util.Random;

public class Cache {
	private DoublyLinkedList list;
	private HashMap<String, DListNode> index;
	private int capacity;
	
	public Cache(int capacity) {
		this.capacity = capacity;
		list = new DoublyLinkedList();
		index = new HashMap<String, DListNode>();
	}
	
	public void put(String key, Integer value) {
		//handle duplicate key
		DListNode p = index.get(key);
		if(p != null) {
			p.value = value;
			list.removeAddLast(p);
			return;
		}
		//is cache full?
		if(list.size() == capacity) {
			DListNode tmp = list.removeFirst();
			index.remove(tmp.key);
		}
		p = list.addLast(key, value);
		index.put(key, p);
	}
	//O(1)
	public Integer get(String key) {
		DListNode tmp = index.get(key);
		if(tmp == null) return null;
		list.removeAddLast(tmp);
		return tmp.value;
	}

	public void display() {
		list.display();
	}
	
	public static void main(String[] args) {
		Cache cache = new Cache(3);
		Random r = new Random(100);
		for(int i = 1; i <= 10; ++i) {
			String key = "random"+i;
			int value = r.nextInt(100);
			cache.put(key, value);
			cache.display();
			if(i == 5) {
				cache.get("random4");
			    cache.display();
			}
		}
	}
	
}

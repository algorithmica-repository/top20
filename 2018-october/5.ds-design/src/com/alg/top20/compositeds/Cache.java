package com.alg.top20.compositeds;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

class DListNode {
	Integer key;
	String value;
	DListNode prev;
	DListNode next;
	public DListNode() {
		prev = next = this;
	}
	public DListNode(Integer key, String value) {
		this();
		this.key = key;
		this.value = value;
	}
	
}
class DoublyLinkedList {
	private DListNode head;
	private int size;
	
	public DoublyLinkedList() {
		head = new DListNode();
		size = 0;
	}
	
	public int size() {
		return size;
	}
	public DListNode removeFirst() {
		DListNode tmp = head.next;
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;
		--size;
		return tmp;
	}
	public DListNode addLast(Integer key, String value) {
		DListNode tmp = new DListNode(key, value);
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
		++size;
		return tmp;
	}
	public void removeAddLast(DListNode tmp) {
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;
		
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
	}
	public void display() {
		for(DListNode current = head.next; current != head; current = current.next)
			System.out.print("("+current.key + "," + current.value+")");
		System.out.println();
	}
}
public class Cache {
	private DoublyLinkedList list;
	private HashMap<Integer, DListNode> index;
	private int capacity;
	
	public Cache(int capacity) {
		this.capacity = capacity;
		index = new HashMap<Integer, DListNode>();
		list = new DoublyLinkedList();
	}
	
	public String get(Integer key) {
		DListNode tmp = index.get(key);
		if(tmp == null) return null;
		list.removeAddLast(tmp);
		return tmp.value;
	}
	
	private boolean isFull() {
		return list.size() == capacity;
	}
	public void put(Integer key, String value) {
		DListNode tmp = index.get(key);
		if(tmp != null) {
			tmp.value = value;
			list.removeAddLast(tmp);
		} else {
			if(isFull()) {
				tmp = list.removeFirst();
				index.remove(tmp.key);
			}
			tmp = list.addLast(key, value);
			index.put(key, tmp);
		}
	}
	
	public void display() {
		list.display();
	}
	
	public static void main(String[] args) {
		Cache cache = new Cache(4);
		Random r = new Random(100);
		for(int i = 1; i <= 5; ++i) {
			cache.put(r.nextInt(10)+1, UUID.randomUUID().toString());
			cache.display();
		}
		cache.get(5);
		cache.display();
	}

}

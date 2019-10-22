package com.alg.top20.setmap;

import java.util.HashMap;
import java.util.Random;

class DListNode {
	DListNode prev;
	DListNode next;
	Integer key;
	String value;

	public DListNode() {
		prev = next = this;
	}

	public DListNode(Integer key, String value) {
		this.key = key;
		this.value = value;
		prev = next = this;
	}
}

class DLinkedList {
	private DListNode head;
	private int size;

	public DLinkedList() {
		head = new DListNode();
	}

	public void removeAddLast(DListNode p) {
		p.prev.next = p.next;
		p.next.prev = p.prev;
		p.prev = head.prev;
		p.next = head;
		head.prev.next = p;
		head.prev = p;
	}

	public DListNode removeFirst() {
		DListNode tmp = head.next;
		tmp.next.prev = head;
		head.next = tmp.next;
		return tmp;
	}

	public DListNode addLast(Integer key, String value) {
		DListNode tmp = new DListNode(key, value);
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
		return tmp;
	}

	public void display() {
		for (DListNode current = head.next; current != head; current = current.next) {
			System.out.print("(" + current.key + "," + current.value + ")->");
		}
		System.out.println();
	}

	public int size() {
		return size;
	}
}

public class LinkedHashCache {
	private HashMap<Integer, DListNode> index;
	private DLinkedList list;
	private int capacity;

	public LinkedHashCache(int capacity) {
		this.capacity = capacity;
		list = new DLinkedList();
		index = new HashMap<Integer, DListNode>();
	}

	public String get(Integer key) {
		DListNode node = index.get(key);
		list.removeAddLast(node);
		return node.value;
	}

	public void put(Integer key, String value) {
		DListNode tmp = index.get(key);
		if (tmp != null) {
			tmp.value = value;
			list.removeAddLast(tmp);
			return;
		}
		if (list.size() == capacity) {
			DListNode node = list.removeFirst();
			index.remove(node.key);
		}
		tmp = list.addLast(key, value);
		index.put(key, tmp);
	}

	public void display() {
		list.display();
	}

	public static void main(String[] args) {
		LinkedHashCache cache = new LinkedHashCache(5);
		Random r = new Random(100);
		for(int i = 0; i < 10; ++i) {
			cache.put(r.nextInt(5)+1, "value"+(i+1));
			cache.display();
		}
		cache.get(1);
		cache.display();

	}

}

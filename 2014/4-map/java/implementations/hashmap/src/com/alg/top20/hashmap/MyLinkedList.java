package com.alg.top20.hashmap;
import java.util.LinkedList;
import java.util.Queue;

public class MyLinkedList<Key extends Comparable<Key>, Value> {
	private int N; // number of key-value pairs
	private final Node head; // the linked list of key-value pairs

	private class Node {
		private Key key;
		private Value val;
		private Node next;

		public Node() {
		}

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	public MyLinkedList() {
		head = new Node();
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public Value get(Key key) {
		for (Node x = head.next; x != null; x = x.next) {
			if (key.equals(x.key))
				return x.val;
		}
		return null;
	}

	public void put(Key key, Value val) {
		Node current = head;
		while (current.next != null) {
			int res = key.compareTo(current.next.key);
			if (res == 0) {
				current.val = val;
				return;
			}
			if (res > 0)
				current = current.next;
			else {
				break;
			}
		}
		current.next = new Node(key, val, current.next);
		N++;
	}

	public void remove(Key key) {
		for (Node current = head; current.next != null; current = current.next) {
			if (key.equals(current.next.key)) {
				current.next = current.next.next;
				N--;
			}
		}
	}

	public Queue<Key> keys() {
		Queue<Key> queue = new LinkedList<Key>();
		for (Node x = head.next; x != null; x = x.next)
			queue.add(x.key);
		return queue;
	}

}

package com.alg.top20.hashmap;
import java.util.LinkedList;
import java.util.Queue;

public class MyHashMap<Key extends Comparable<Key>, Value> {
	private static final int INIT_CAPACITY = 11;
	private int N; // number of key-value pairs
	private int M; // number of buckets
	private MyLinkedList<Key, Value>[] st; // array of linked-list symbol tables

	public MyHashMap() {
		this(INIT_CAPACITY);
	}

	// create separate chaining hash table with M lists
	public MyHashMap(int M) {
		this.M = M;
		st = new MyLinkedList[M];
		for (int i = 0; i < M; i++)
			st[i] = new MyLinkedList<Key, Value>();
	}

	// resize the hash table to have the given number of chains b rehashing all
	// of the keys
	private void resize(int chains) {
		MyHashMap<Key, Value> temp = new MyHashMap<Key, Value>(chains);
		for (int i = 0; i < M; i++) {
			for (Key key : st[i].keys()) {
				temp.put(key, st[i].get(key));
			}
		}
		this.M = temp.M;
		this.N = temp.N;
		this.st = temp.st;
	}

	// hash value between 0 and M-1
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
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
		int i = hash(key);
		return st[i].get(key);
	}

	public void put(Key key, Value val) {
		// double table size if average length of list >= 10
		if (N >= 10 * M)
			resize(2 * M);

		int i = hash(key);
		if (!st[i].contains(key))
			N++;
		st[i].put(key, val);
	}

	public boolean remove(Key key) {
		int i = hash(key);
		if (st[i].contains(key)) {
			N--;
			st[i].remove(key);
			return true;
		}
		return false;
	}

	public Queue<Key> keys() {
		Queue<Key> queue = new LinkedList<Key>();
		for (int i = 0; i < M; i++) {
			for (Key key : st[i].keys())
				queue.add(key);
		}
		return queue;
	}

}
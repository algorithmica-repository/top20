package com.alg.top20.set;


public class HashSet implements ISet {
	private ListNode[] htbl;
	private int size;
	private static final int INIT_BUCKETS = 11;
	private static final int THRESHOLD = 10;
	
	public HashSet() {
		htbl = new ListNode[INIT_BUCKETS];
		for(int i = 0; i < INIT_BUCKETS; ++i)
			htbl[i] = new ListNode();
		size = 0;
	}
	private void rehash() {
		
	}
	
	@Override
	public boolean add(Integer key) {
		if(size / htbl.length > THRESHOLD)
			rehash();
		int bindex = key.hashCode() % htbl.length;
		ListNode current = htbl[bindex];
		for(;current.next != null; current = current.next){
			if(current.next.data.equals(key)) {
				return false;
			}
		}
		current.next = new ListNode(key);
		++size;
		return true;
	}

	@Override
	public boolean contains(Integer key) {
		int bindex = key.hashCode() % htbl.length;
		ListNode current = htbl[bindex].next;
		for(;current != null; current = current.next){
			if(current.data.equals(key))
				return true;
		}
		return false;
	}

	@Override
	public boolean remove(Integer key) {
		int bindex = key.hashCode() % htbl.length;
		ListNode current = htbl[bindex];
		for(;current.next != null; current = current.next){
			if(current.next.data.equals(key)) {
				current.next = current.next.next;
				--size;
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void display() {
		for(int i = 0; i < htbl.length; ++i) {
			System.out.print("Bucket-" + i + ":");
			for(ListNode current = htbl[i].next; current != null; current = current.next) {
				System.out.print(current.data+ " ");
			}
			System.out.println();
		}
	}

}

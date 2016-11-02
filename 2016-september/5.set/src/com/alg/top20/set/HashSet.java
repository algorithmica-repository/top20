package com.alg.top20.set;

public class HashSet implements ISet {
	
	private ListNode[] htbl;
	private int size;
	
	public HashSet() {
		htbl = new ListNode[11];
		for(int i = 0; i < htbl.length; ++i)
			htbl[i] = new ListNode();
		size = 0;
	}

	private void rehash() {
		ListNode[] newtbl = new ListNode[htbl.length * 2];
		for(int i = 0; i < newtbl.length; ++i)
			newtbl[i] = new ListNode();
		
		ListNode tmp;
		for(int i = 0; i < htbl.length; ++i) {
			for(ListNode current = htbl[i].next; current != null; current = tmp) {
				 int newbucket = current.data.hashCode() % newtbl.length;
				 tmp = current.next;
				 current.next = newtbl[newbucket].next;
				 newtbl[newbucket].next = current;
			}
		}
		
		htbl = newtbl;		
	}
	
	//O(1) amortized
	@Override
	public boolean add(Integer e) {
		if(size / htbl.length > 20)
			rehash();
		int bucket = e.hashCode() % htbl.length;
		for(ListNode current = htbl[bucket].next; current != null; current = current.next) {
			if(current.data.equals(e))
				return false;
		}
		ListNode tmp = new ListNode(e);
		tmp.next = htbl[bucket].next;
		htbl[bucket].next = tmp;
		++size;
		return true;
	}

	//O(1)
	@Override
	public boolean contains(Integer e) {
		int bucket = e.hashCode() % htbl.length;
		for(ListNode current = htbl[bucket].next; current != null; current = current.next) {
			if(current.data.equals(e))
				return true;
		}
		return false;
	}

	//O(1)
	@Override
	public boolean remove(Integer e) {
		int bucket = e.hashCode() % htbl.length;
		for(ListNode current = htbl[bucket]; current.next != null; current = current.next) {
			ListNode tmp = current.next;
			if(tmp.data.equals(e)) {	
				current.next = tmp.next;
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
			System.out.print("Bucket-" + i +":");
			for(ListNode current = htbl[i].next; current != null; current = current.next) {
				System.out.print(current.data + " ");
			}
			System.out.println();
		}
		
	}

}

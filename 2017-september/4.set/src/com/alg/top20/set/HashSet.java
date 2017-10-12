package com.alg.top20.set;

class ListNode {
	Integer data;
	ListNode next;
	
	ListNode() {
		
	}
	ListNode(Integer data)  {
		this.data = data;
	}
	
}
public class HashSet implements ISet {
	private ListNode[] buckets;
	private int size;
	private static final int THRESHOLD = 10;
	
	public HashSet() {
		buckets = new ListNode[11];
		for(int i = 0; i < buckets.length; ++i)
			buckets[i] = new ListNode();
		size = 0;
	}
	private void rehash() {
		ListNode[] buckets_new = new ListNode[2*buckets.length];
		for(int i = 0; i < buckets_new.length; ++i)
			buckets_new[i] = new ListNode();

		ListNode tmp;
		for(int i = 0; i < buckets.length; ++i) {
			for(ListNode current = buckets[i].next; current != null; current = tmp) {
				int bind = current.data.hashCode() % buckets_new.length;
				tmp = current.next;
				current.next = buckets_new[bind].next;
				buckets_new[bind].next = current;
			}
		}		
		buckets = buckets_new;
	}
	//O(1) am
	@Override
	public boolean add(Integer e) {
		//check if element e already exist in set
		if(contains(e)) return false;
		//verify whether rehash required or not
		float avgsize = size / buckets.length;
		if(avgsize >= THRESHOLD) {
			rehash();
		}	
		//add the element at start of bucket
		int bind = e.hashCode() % buckets.length;
		ListNode tmp = new ListNode(e);
		tmp.next = buckets[bind].next;
		buckets[bind].next = tmp;
		++size;
		return true;
	}

	//O(1)
	@Override
	public boolean contains(Integer e) {
		int bind = e.hashCode() % buckets.length;
		for(ListNode current = buckets[bind].next; current != null; current = current.next) {
			if(current.data.equals(e))
				return true;
		}
		return false;
	}

	//O(1)
	@Override
	public boolean remove(Integer e) {
		int bind = e.hashCode() % buckets.length;
		for(ListNode current = buckets[bind]; current.next != null; current = current.next) {
			if(current.next.data.equals(e)) {
				current.next = current.next.next;
				--size;
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	//O(n)
	@Override
	public void display() {
		for(int i = 0; i < buckets.length; ++i) {
			System.out.print("Bucket-" +i+":" );
			for(ListNode current = buckets[i].next; current != null; current = current.next) {
				System.out.print(current.data+" ");
			}
			System.out.println();
		}
	}

}

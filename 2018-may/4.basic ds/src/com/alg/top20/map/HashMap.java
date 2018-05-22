package com.alg.top20.map;

import java.util.Random;
import java.util.UUID;

class ListNode {
	String key;
	Integer value;
	ListNode next;
	
	ListNode() {
		
	}
	ListNode(String key, Integer value)  {
		this.key = key;
		this.value = value;
	}
	
}
public class HashMap {
	private ListNode[] htbl;
	private int size;

	public HashMap() {
		htbl = new ListNode[11];
		for (int i = 0; i < htbl.length; ++i)
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
				 int newbucket = getHashCode(current.key) % newtbl.length;
				 tmp = current.next;
				 current.next = newtbl[newbucket].next;
				 newtbl[newbucket].next = current;
			}
		}
		
		htbl = newtbl;		
	}
	
	
	//O(1) am
	public boolean put(String key, Integer value) {
		if(size / htbl.length > 10)
			rehash();
		int bucket = getHashCode(key) % htbl.length;
		for(ListNode current = htbl[bucket].next; current != null; current = current.next) {
			if(current.key.equals(key))
				return false;
		}
		ListNode tmp = new ListNode(key, value);
		tmp.next = htbl[bucket].next;
		htbl[bucket].next = tmp;
		++size;
		return true;

	}

	private int getHashCode(String key) {
		/*int res = 0;
		for(int i = 0; i < key.length(); ++i)
			res  += key.charAt(i);
		return res;*/
		return Math.abs(key.hashCode());
	}

	public Integer get(String key) {
		int bucket = getHashCode(key) % htbl.length;
		for(ListNode current = htbl[bucket].next; current != null; current = current.next) {
			if(current.key.equals(key))
				return current.value;
		}
		return null;
	}

	
	public boolean remove(String key) {
		int bucket = getHashCode(key) % htbl.length;
		for(ListNode current = htbl[bucket]; current.next != null; current = current.next) {
			ListNode tmp = current.next;
			if(tmp.key.equals(key)) {	
				current.next = tmp.next;
				--size;
				return true;
			}
		}
		return false;

	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public void display() {
		for(int i = 0; i < htbl.length; ++i) {
			System.out.print("Bucket-" + i +":");
			for(ListNode current = htbl[i].next; current != null; current = current.next) {
				System.out.print("(" + current.key + "," + current.value + ") ");
			}
			System.out.println();
		}

	}

	public boolean containsKey(String key) {
		int bucket = getHashCode(key) % htbl.length;
		for(ListNode current = htbl[bucket].next; current != null; current = current.next) {
			if(current.key.equals(key))
				return true;
		}
		return false;
	}

	public boolean containsValue(Integer value) {
		for(int i = 0; i < htbl.length; ++i) {
			for(ListNode current = htbl[i].next; current != null; current = current.next) {
				if(current.value.equals(value))
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		HashMap hmap = new HashMap();
		
		int limit = Integer.parseInt(args[0]);
		Random r = new Random(100);
		
		for(int i = 1; i <= limit; ++i) {
			hmap.put(UUID.randomUUID().toString(),r.nextInt(1000));
		}
		System.out.println(hmap.size());
		hmap.display();

	}



}

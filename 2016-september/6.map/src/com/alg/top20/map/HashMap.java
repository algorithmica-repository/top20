package com.alg.top20.map;

public class HashMap implements IMap {
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
	@Override
	public boolean put(String key, Integer value) {
		if(size / htbl.length > 20)
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
	//O(1)
	@Override
	public Integer get(String key) {
		int bucket = getHashCode(key) % htbl.length;
		for(ListNode current = htbl[bucket].next; current != null; current = current.next) {
			if(current.key.equals(key))
				return current.value;
		}
		return null;
	}

	
	//O(1)
	@Override
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

	//O(1)
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	//O(n)
	@Override
	public void display() {
		for(int i = 0; i < htbl.length; ++i) {
			System.out.print("Bucket-" + i +":");
			for(ListNode current = htbl[i].next; current != null; current = current.next) {
				System.out.print("(" + current.key + "," + current.value + ") ");
			}
			System.out.println();
		}

	}

	//O(1)
	@Override
	public boolean containsKey(String key) {
		int bucket = getHashCode(key) % htbl.length;
		for(ListNode current = htbl[bucket].next; current != null; current = current.next) {
			if(current.key.equals(key))
				return true;
		}
		return false;
	}

	//O(n)
	@Override
	public boolean containsValue(Integer value) {
		for(int i = 0; i < htbl.length; ++i) {
			for(ListNode current = htbl[i].next; current != null; current = current.next) {
				if(current.value.equals(value))
					return true;
			}
		}
		return false;
	}

}

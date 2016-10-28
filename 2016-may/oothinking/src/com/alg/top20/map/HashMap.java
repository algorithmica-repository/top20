package com.alg.top20.map;

public class HashMap implements IMap {
	
	class ListNode {
		Integer key;
		String value;
		ListNode next;

		public ListNode(Integer key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public ListNode() {
			super();
		}

	}

	private int size;
	private ListNode[] htbl;
	private final static int LOADFACTOR = 10;
	
	public HashMap() {
		size = 0;
		htbl = new ListNode[11];
		for(int i = 0; i < 11; ++i) {
			htbl[i] = new ListNode();
		}
	}
	
	private boolean listadd(ListNode head, Integer key, String value) {
		ListNode current = head;
		while(current.next != null) {
			int ret = key.compareTo(current.next.key);
			if(ret == 0) return false;
			else if(ret > 0)
				current = current.next;
			else
				break;
		}			
		ListNode tmp = new ListNode(key, value);
		tmp.next = current.next;
		current.next = tmp;
		return true;
	}
	
	private void rehash() {
		ListNode[] newtbl = new ListNode[htbl.length * 2];
		for(int i = 0; i < newtbl.length; ++i) {
			newtbl[i] = new ListNode();
		}
		
		ListNode current;
		for(int i = 0; i < htbl.length; ++i) {
			for(current = htbl[i].next; current != null; current = current.next) {
				int newbucket = current.key.hashCode() % newtbl.length;
				listadd(newtbl[newbucket], current.key, current.value);
			}
		}
		
		htbl = newtbl;
	}
	
	@Override
	public boolean add(Integer key, String value) {
		if(size / htbl.length > LOADFACTOR) {
			rehash();
		}
		int bucket = key.hashCode() % htbl.length;		
		//int bucket = 0;
		boolean res = listadd(htbl[bucket], key, value);
		if(res == true) ++size;
		return res;
	}

	@Override
	public boolean containsKey(Integer k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(String v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Integer k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String get(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean set(Integer k, String v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {		
		ListNode current;
		for(int i = 0; i < htbl.length; ++i) {
			System.out.print("Bucket:" + i +" ");
			for(current = htbl[i].next; current != null; current = current.next) {
				System.out.print("(" +current.key + "," + current.value + ") ");
			}
			System.out.println();
		}

	}

}

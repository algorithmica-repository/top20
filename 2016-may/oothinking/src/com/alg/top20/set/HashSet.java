package com.alg.top20.set;

public class HashSet implements ISet {
	
	class ListNode {
		Integer data;
		ListNode next;

		public ListNode(Integer data) {
			super();
			this.data = data;
		}

		public ListNode() {
			super();
		}

	}

	private int size;
	private ListNode[] htbl;
	private final static int LOADFACTOR = 10;
	
	public HashSet() {
		size = 0;
		htbl = new ListNode[11];
		for(int i = 0; i < 11; ++i) {
			htbl[i] = new ListNode();
		}
	}
	
	private boolean listadd(ListNode head, Integer e) {
		ListNode current = head;
		while(current.next != null) {
			int ret = e.compareTo(current.next.data);
			if(ret == 0) return false;
			else if(ret > 0)
				current = current.next;
			else
				break;
		}			
		ListNode tmp = new ListNode(e);
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
				int newbucket = current.data.hashCode() % newtbl.length;
				listadd(newtbl[newbucket], current.data);
			}
		}
		
		htbl = newtbl;
	}
	
	@Override
	public boolean add(Integer e) {
		if(size / htbl.length > LOADFACTOR) {
			rehash();
		}
		int bucket = e.hashCode() % htbl.length;		
		//int bucket = 0;
		boolean res = listadd(htbl[bucket], e);
		if(res == true) ++size;
		return res;
	}

	@Override
	public boolean contains(Integer e) {
	
		return false;
	}

	@Override
	public boolean remove(Integer e) {
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
				System.out.print(current.data + " ");
			}
			System.out.println();
		}

	}

	@Override
	public void serialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deserialize() {
		// TODO Auto-generated method stub
		
	}

	
}

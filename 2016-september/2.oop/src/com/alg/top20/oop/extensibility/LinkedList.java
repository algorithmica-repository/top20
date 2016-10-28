package com.alg.top20.oop.extensibility;

public class LinkedList implements IList {
	
	private class ListNode {
		Integer data;
		ListNode next;
		public ListNode() {
			
		}		
	}
	
	private ListNode first;
	private int size;
	
	public LinkedList() {
		
	}

	@Override
	public int get(int ind) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}

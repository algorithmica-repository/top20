package com.alg.top20.list;

class ListNode {
	Integer data;
	ListNode next;
	
	ListNode() {
		
	}
	ListNode(Integer data)  {
		this.data = data;
	}
	
}
public class LinkedList implements List {
	private ListNode head;
	private ListNode last;
	private int size;
	
	public LinkedList() {
		head = last = new ListNode();
		size = 0;
	}
	//O(1)
	public void add(Integer e) {
		ListNode tmp = new ListNode(e);
		last.next = tmp;
		last = tmp;
		++size;
	}
	
	//O(n)
	public void display() {
		for(ListNode current = head.next; current != null; current = current.next)
			System.out.print(current.data+ " ");
	}

	//O(n)
	public Integer get(int ind) {
		ListNode current = head;
		for(int i = 0; i <= ind; ++i)
			current = current.next;
		return current.data;
	}
	

}

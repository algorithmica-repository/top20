package com.alg.top20.list;

//no data level encapsulation
class ListNode {
	Integer data;
	ListNode next;
	ListNode(Integer data) {
		this.data = data;
		this.next = null;
	}
	ListNode() {
		
	}
}
public class LinkedList implements IList {
	private ListNode head;
	private ListNode last;
	private int size;

	public LinkedList() {
		head = new ListNode();
		last = head;
		size = 0;
	}
	//O(n)
	public Integer get(int index) {
		// TODO Auto-generated method stub
		return null;
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
		ListNode current;
		for(current = head.next;current!=null;current=current.next) {
			System.out.println(current.data);
		}
		
	}

	@Override
	public int size() {
		return size;
	}

}

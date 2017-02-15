package com.alg.top20.linkedlist;

public class TestLinkedList {
	
	public static void addFirst(ListNode head, Integer e) {
		ListNode tmp = new ListNode(e);
		tmp.next = head.next;
		head.next = tmp;
	}

	public static ListNode getLastNode(ListNode head) {
		ListNode current;
		for(current = head.next;current.next!=null;current=current.next) {
		}
		return current;
	}
	public static void display(ListNode head) {
		ListNode current;
		for(current = head.next;current!=null;current=current.next) {
			System.out.print(current+"->");
		}
		System.out.println();
	}

}

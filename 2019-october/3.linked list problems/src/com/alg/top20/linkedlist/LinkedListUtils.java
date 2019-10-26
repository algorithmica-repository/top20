package com.alg.top20.linkedlist;

public class LinkedListUtils {

	public static ListNode createList(int n) {
		ListNode head = new ListNode();
		for(int i = 1; i <= n; ++i) {
			ListNode tmp =  new ListNode(i);
			tmp.next = head.next;
			head.next = tmp;
		}
		return head;
	}
	
	public static ListNode createListwithLoop(int n) {
		ListNode head = new ListNode();
		ListNode tmp = null;
		for(int i = 1; i <= n; ++i) {
			tmp =  new ListNode(i);
			tmp.next = head.next;
			head.next = tmp;
		}
		tmp = head;
		while(tmp.next != null) 
			tmp = tmp.next;
		tmp.next = head.next;		
		return head;
	}
	
	public static void display(ListNode head) {
		ListNode current = head.next;
		for(; current != null; current = current.next) {
			String s = current.toString();
			System.out.print(s.split("@")[1] + "->");
		}
		System.out.println();
	}
	
	public static void displayWithLoop(ListNode head) {
		ListNode current = head.next;
		do {
			System.out.print(current.data + "->");
			current = current.next;
		} while(current != head.next);
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

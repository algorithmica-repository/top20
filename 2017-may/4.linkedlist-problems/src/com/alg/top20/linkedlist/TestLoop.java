package com.alg.top20.linkedlist;

public class TestLoop {

	public static void testCase1(int n) {
		ListNode head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		System.out.println(LoopDetection.detectLoop3(head));
	}
	
	public static void testCase2(int n) {
		ListNode head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		ListNode current;
		for(current = head; current.next != null; current = current.next);
		current.next = head.next;
		System.out.println(LoopDetection.detectLoop3(head));
	}
	
	public static void testCase3(int n) {
		ListNode head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		ListNode current;
		for(current = head; current.next != null; current = current.next);
		current.next = current;
		System.out.println(LoopDetection.detectLoop3(head));
	}
	
	public static void testCase4(int n) {
		ListNode head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		ListNode current;
		for(current = head; current.next != null; current = current.next);
		//current.next = ;
		System.out.println(LoopDetection.detectLoop3(head));
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		testCase1(n);
		testCase2(n);
		testCase3(n);
	}

}

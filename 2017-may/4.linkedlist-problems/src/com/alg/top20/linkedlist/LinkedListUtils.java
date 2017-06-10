package com.alg.top20.linkedlist;

import java.util.Random;

public class LinkedListUtils {

	public static void display(ListNode head) {
		ListNode current;
		String address;
		for (current = head.next; current != null; current = current.next) {
			if (current.next != null) {
				String tmp = current.next.toString();
				address = tmp.substring(tmp.indexOf('@') + 1);
			} else {
				address = "null";
			}
			System.out.print("[" + current.data + "," + address + "]");
		}
		System.out.println();
	}

	public static void displayNodes(ListNode head) {
		for (ListNode current = head.next; current != null; current = current.next) {
			String tmp = current.toString();
			String address = tmp.substring(tmp.indexOf('@') + 1);
			System.out.println(address);
		}
	}
	
	public static ListNode createList(int n) {
		Random r = new Random();
		ListNode head = new ListNode();
		for (int i = 0; i < n; ++i) {
			ListNode tmp = new ListNode(r.nextInt(n) + 1);
			tmp.next = head.next;
			head.next = tmp;
		}
		return head;
	}
}

package com.alg.top20.ll;

import java.util.Random;

public class RandomNode {

	public static ListNode getRandom1(ListNode head) {
		Random r = new Random();
		int length = 0;
		ListNode current;
		for(current = head.next; current != null; current = current.next )
			++length;
		int rindex = r.nextInt(length);
		current = head.next;
		for(int i = 0; i <= rindex; ++i)
			current = current.next;
		return current;
	}
	
	public static ListNode getRandom2(ListNode head) {
		Random r = new Random();
		ListNode result = head.next;
		for(ListNode current = result.next; current != null; current = current.next){
			if(r.nextInt(2) == 0)
				result = current;
		}
		return result;
	}
	
	public static ListNode getRandom3(ListNode head) {
		Random r = new Random();
		ListNode result = head.next;
		int i = 2;
		for(ListNode current = result.next; current != null; current = current.next){
			if(r.nextInt(i) == 0)
				result = current;
			++i;
		}
		return result;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListNode head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		for(int i = 1; i <= 30; ++i)
			System.out.println(getRandom3(head));
	}

}

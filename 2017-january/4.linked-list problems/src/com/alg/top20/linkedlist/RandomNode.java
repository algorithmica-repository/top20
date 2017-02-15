package com.alg.top20.linkedlist;

import java.util.Random;

public class RandomNode {

	public static ListNode getRandom1(ListNode head) {
		int size = 0;
		for(ListNode current = head.next; current != null; current = current.next)
			++size;
		Random r = new Random();
		int rindex = r.nextInt(size);
		ListNode current = head.next;
		while(rindex > 0) {
			current = current.next;
			--rindex;
		}
		return current;
	}
	//simulate coin toss experiment at each new node
	//if head comes up then pick the current node
	//otherwise keep old node
	//biased toward last few nodes
	public static ListNode getRandom2(ListNode head) {
		Random r = new Random();
		ListNode rnode = head.next;
		for(ListNode current = rnode.next; current != null; current = current.next) {
			int outcome = r.nextInt(2);
			if(outcome == 0)
				rnode = current;
		}
		return rnode;
	}
	
	public static ListNode getRandom3(ListNode head) {
		Random r = new Random();
		ListNode rnode = head.next;
		int size = 1;
		for(ListNode current = rnode.next; current != null; current = current.next) {
			++size;
			int outcome = r.nextInt(size);
			if(outcome == (size-1))
				rnode = current;
		}
		return rnode;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		ListNode head = new ListNode();
		for(int i = 0; i < n; ++i) {
			TestLinkedList.addFirst(head, i);
		}
		TestLinkedList.display(head);
		System.out.println(getRandom3(head));
		
		//simulation of coin toss experiment
		/*Random r = new Random();
		int nones = 0;
		int nzeroes = 0;
		for(int i = 1; i <= 1000; ++i) {
			if(r.nextInt(2) == 0) ++nzeroes;
			else ++nones;
		}
		System.out.println(nzeroes + " " + nones);
*/	}

}

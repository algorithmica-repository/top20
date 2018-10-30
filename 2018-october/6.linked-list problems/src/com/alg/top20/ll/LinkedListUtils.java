package com.alg.top20.ll;

public class LinkedListUtils {

		public static ListNode createList(int n) {
			ListNode head = new ListNode();
			for(int i = 1; i <= n; ++i) {
				ListNode tmp = new ListNode();
				tmp.next = head.next;
				head.next = tmp;
			}
			return head;
		}
		
		public static ListNode createListWithLoop(int n) {
			ListNode head = new ListNode(), last;
			last = head;
			
			for(int i = 1; i <= n; ++i) {
				ListNode tmp = new ListNode();
				last.next = tmp;
				last = tmp;
			}
			display(head);
			last.next = head;
			return head;
		}
		public static void display(ListNode head) {
			for(ListNode current = head.next; current != null; current = current.next) {
				System.out.print(current.toString().split("@")[1]+"->");		
			}
			System.out.println();
		}	
}

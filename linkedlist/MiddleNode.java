/*Find the middle node of a linked list
 * */
package com.algorithmica.linkedlists;
import com.algorithmica.linkedlists.LinkedListNode;
public class MiddleNode {
	public static void main(String args[]) {
		LinkedListNode head = LinkedListNode.createList();
		LinkedListNode.printList(head);
		LinkedListNode slow, fast;
		slow = fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

		}
		System.out.println("Middle is " + slow.data);
	}

}

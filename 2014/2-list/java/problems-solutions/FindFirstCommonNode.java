/*Given two linked lists such that they share a few common nodes. Fine the intersecting node.
 * 
 */
package com.algorithmica.linkedlists;

public class FindFirstCommonNode {
	public static void main(String args[]) {
		LinkedListNode head1 = createList();
		LinkedListNode head2 = createList();
		// corrupt both the lists
		LinkedListNode current = head2;
		while (current.next != null)
			current = current.next;
		current.next = head1.next.next.next;
		LinkedListNode node = findFirstCommonNode(head1, head2);
		if (node != null) {
			System.out.println("first common node is " + node.data);
		}
	}

	static LinkedListNode findFirstCommonNode(LinkedListNode head1,
			LinkedListNode head2) {
		int count1 = 0;
		int count2 = 0;
		// Now we need to find out the first common node
		// find the length of first list
		LinkedListNode current1 = head1;
		while (current1 != null) {
			current1 = current1.next;
			count1++;
		}
		// find the length of second list
		LinkedListNode current2 = head2;
		while (current2 != null) {
			current2 = current2.next;
			count2++;
		}
		current2 = head2;
		while (count1 < count2) {
			current2 = current2.next;
			count2--;
		}
		current1 = head1;
		while (count2 < count1) {
			current1 = current1.next;
			count1--;
		}
		while (current1 != current2 && current1 != null && current2 != null) {
			current1 = current1.next;
			current2 = current2.next;
		}
		if (current1 == current2)
			return current1;
		return null;

	}

	private static LinkedListNode createList() {
		LinkedListNode a = new LinkedListNode(10);
		LinkedListNode b = new LinkedListNode(20);
		LinkedListNode c = new LinkedListNode(30);
		LinkedListNode d = new LinkedListNode(40);
		LinkedListNode e = new LinkedListNode(50);
		LinkedListNode f = new LinkedListNode(60);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		return a;
	}

}

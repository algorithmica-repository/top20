/*Given a linked list, where each node contains one more extra field 
called as random pointer (other than the normal "next" pointer) which 
could point to any other node or itself i.e., there could be loops. Write 
an efficient function to duplicate this linked list. What are the time and 
space complexities of your solution?
Function Prototype:
  Node DuplicateList(Node head)
  
  class Node
{
    int element;
    Node next;
    Node random;
}
 * */
package com.assignments.linkedlists;

public class DuplicateList {

	public static void main(String[] args) {

		LNode l1 = createList();
		System.out.println("Actual list: ");
		printListRandom(l1);
		LNode l2 = duplicateList(l1);
		System.out.println("Duplicate list: ");
		printListRandom(l2);

	}

	private static void printListRandom(LNode l) {
		// TODO Auto-generated method stub
		while (l != null) {
			System.out.println(l.element + " random pointer is "
					+ l.random.element);
			l = l.next;
		}

	}

	static LNode duplicateList(LNode head1) {
		LNode current1 = head1;
		LNode tmp1;
		LNode current2;
		LNode head2;
		// creating a new list nodes and placing them within the existing list
		while (current1 != null) {
			LNode tmp = new LNode(current1.element);
			tmp1 = current1.next;
			current1.next = tmp;
			tmp.next = tmp1;
			current1 = tmp1;

		}

		// filling the random pointer field in the new nodes
		current1 = head1;
		while (current1 != null) {
			current1.next.random = current1.random.next;
			current1 = current1.next.next;
		}
		// splitting the two lists

		head2 = head1.next;

		for (current1 = head1, current2 = head2; current2.next != null;) {
			current1.next = current1.next.next;
			current2.next = current2.next.next;
			current1 = current1.next;
			current2 = current2.next;

		}
		return head2;
	}

	static LNode createList() {
		LNode a1 = new LNode(10);
		LNode a2 = new LNode(20);
		LNode a3 = new LNode(30);
		a1.next = a2;
		a2.next = a3;
		a1.random = a2;
		a2.random = a1;
		a3.random = a2;
		return a1;
	}

}

class LNode {
	int element;
	LNode next;
	LNode random;

	LNode(int element) {
		this.element = element;
		this.next = null;
		this.random = null;

	}
}

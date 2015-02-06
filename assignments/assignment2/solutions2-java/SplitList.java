/* Write an efficient  function which divides the list into two equal 
sublists  and put the second sublist  at front of  first sublist in single 
pass only. If the number of elements is odd, extra element go into the 
first sublist. What is the space complexity of your solution?
Function Prototype:
    Node  SplitList(Node head)
Input:   2 4 5 3 8 7 6 1 9
Output: 7 6 1 9 2 4 5 3 8
Input:   1 3 5 7 2 4 6 8
Output: 2 4 6 8 1 3 5 7
 * */

package com.assignments.linkedlists;

public class SplitList {

	public static void main(String[] args) {
		Node head = createList();
		System.out.println("actual list: ");
		printList(head);
		head = splitList(head);
		System.out.println("\nafter spliting: ");
		printList(head);

	}

	private static void printList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}

	}

	private static Node createList() {
		Node a = new Node(1);
		Node b = new Node(3);
		Node c = new Node(5);
		Node d = new Node(7);
		Node e = new Node(2);
		Node f = new Node(4);
		Node g = new Node(6);
//		Node h = new Node(8);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
//		g.next = h;

		return a;
	}

	static Node splitList(Node head) {
		if (head == null)
			return null;
		Node slow = head;
		Node fast = head;
		Node prevSlow = head;
		Node prevFast = head;
		while (fast != null && fast.next != null) {
			prevSlow = slow;
			prevFast = fast;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast == null) {
			slow = prevSlow;
			fast = prevFast.next;
		}
		fast.next = head;
		head = slow.next;
		slow.next = null;
		return head;
	}

}

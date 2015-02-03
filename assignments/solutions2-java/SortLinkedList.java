/* Write an efficient function to sort  elements of a single linked list. 
Assume that there might be external applications which points to 
some of the nodes of given linked list, so you are not allowed to just 
copy the elements of one node to other. What are the time and space 
complexities of your solution? 
Function prototype:
   void SortList(Node head)*/

package com.assignments.linkedlists;

public class SortLinkedList {

	public static void main(String[] args) {
		LLnode head=createList();
		System.out.println("initial list is: ");
		printList(head);
		System.out.println("\nlist after sorting :");
		head=mergeSort(head);
		printList(head);
		
		
	}

	static LLnode mergeSort(LLnode head) {
		
		// Base case -- length 0 or 1
		if ((head == null) || (head.next == null)) {
			return head;
		}
		LLnode subLists[]=new LLnode[2];
		subLists=frontBackSplit(head); // Split head into 'a' and 'b' sublists
		// We could just as well use AlternatingSplit()
		
		mergeSort(subLists[0]); // Recursively sort the sublists
		mergeSort(subLists[1]);
		head = sortedMerge(subLists[0], subLists[1]); // answer = merge the two sorted lists
									// together
		return head;
	}

	private static LLnode sortedMerge(LLnode a, LLnode b) {
		// TODO Auto-generated method stub
		LLnode result = null;
		// Base cases
		if (a == null)
			return b;
		else if (b == null)
			return a;
		// Pick either a or b, and recur
		if (a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}
	

	static // Uses the fast/slow pointer strategy
	LLnode[] frontBackSplit(LLnode head) {
		LLnode fast;
		LLnode slow;
		LLnode lists[]=new LLnode[2];
		if (head == null || head.next == null) { // length < 2 cases
			lists[0] = head;
			lists[1] = null;
		} else {
			slow = head;
			fast = head.next;
			// Advance 'fast' two nodes, and advance 'slow' one node
			while (fast != null) {
				fast = fast.next;
				if (fast != null) {
					slow = slow.next;
					fast = fast.next;
				}
			}
			// 'slow' is before the midpoint in the list, so split it in two
			// at that point.
			lists[0] = head;
			lists[1] = slow.next;
			slow.next = null;
		}
		return lists;
	}
	private static LLnode createList() {
		LLnode a = new LLnode(1);
		LLnode b = new LLnode(3);
		LLnode c = new LLnode(5);
		LLnode d = new LLnode(7);
		LLnode e = new LLnode(2);
		LLnode f = new LLnode(4);
		LLnode g = new LLnode(6);
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
	private static void printList(LLnode head) {
		LLnode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}


}

class LLnode {
	int data;
	LLnode next;

	LLnode(int data) {
		this.data = data;
	}
}

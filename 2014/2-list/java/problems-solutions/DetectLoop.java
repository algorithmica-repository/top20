/*You are given a linked list that is either NULL-terminated
  (acyclic), or ends in a cycle (cyclic).Write a function which returns true 
  if the list contains a cycle otherwise returns false
 * */
package com.algorithmica.linkedlists;

public class DetectLoop {
	public static void main(String[] args) {
		LinkedListNode root=LinkedListNode.createList();
		//form a cycle
		LinkedListNode current=root;
		while(current.next!=null)
			current=current.next;
		current.next=root.next.next;
		if(detectLoop(root))
		{
			System.out.println("Given list contains a loop");
		}
		else
		{
			System.out.println("Given list doesn't contain any loop");
		}
		

	}
	static boolean detectLoop(LinkedListNode root){
		LinkedListNode slow=root;
		LinkedListNode fast=root;
		do
		{
			slow=slow.next;
			if(fast==null || fast.next==null)
				return false;
			fast=fast.next.next;
			
		}while(slow!=fast);
		return true;
		
	}

}

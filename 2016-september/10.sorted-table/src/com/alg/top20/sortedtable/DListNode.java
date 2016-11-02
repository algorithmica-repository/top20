package com.alg.top20.sortedtable;

public class DListNode {
	Employee value;
	DListNode prev;
	DListNode next;
	
	public DListNode() {
		prev = next = this;
	}
	public DListNode(Employee value) {
		super();
		this.value = value;
	}
	
	
}

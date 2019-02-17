package com.alg.top20.ll;

public class DListNode {
	Integer key;
	String value;
	DListNode prev;
	DListNode next;
	
	public DListNode() {
		prev = next = this;
	}
	
	public DListNode(Integer key, String value) {
		this.key = key;
		this.value = value;
		prev = next = this;
	}

}

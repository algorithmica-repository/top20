package com.alg.top20.cache;

public class DListNode {
	String key;
	Integer value;
	DListNode prev;
	DListNode next;
	
	public DListNode() {
		prev = next = this;
	}
	
	public DListNode(String key, Integer value) {
		this.key = key;
		this.value = value;
		prev = next = this;
	}
}

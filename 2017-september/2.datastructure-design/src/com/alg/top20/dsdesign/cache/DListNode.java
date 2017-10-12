package com.alg.top20.dsdesign.cache;

public class DListNode {
	DListNode prev, next;
	String key;
	Integer value;
	
	
	public DListNode() {
		prev = next = this;
	}
	public DListNode(String key, Integer value) {
		super();
		this.key = key;
		this.value = value;
	}	
}

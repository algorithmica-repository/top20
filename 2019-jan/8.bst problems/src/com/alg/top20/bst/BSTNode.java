package com.alg.top20.bst;

public class BSTNode {
	BSTNode left;
	BSTNode right;
	Integer data;
	int local_rank;
	
	public BSTNode() {
		
	}
	public BSTNode(int data) {
		this.data = data;
		this.local_rank = 1;
	}
}

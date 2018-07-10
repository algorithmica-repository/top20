package com.alg.top20.set;

public class BTreeNode {
	Integer data;
	int lst_size;
	BTreeNode left;
	BTreeNode right;
	
	public BTreeNode(Integer data) {
		this.data = data;
	}
	public BTreeNode(Integer data, BTreeNode left, BTreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public BTreeNode() {
	}
	
	
}

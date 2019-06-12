package com.alg.top20.bst;

public class BSTNode {
	Integer data;
	BSTNode left;
	BSTNode right;
	int lst_size;
	public BSTNode(Integer data) {
		this.data = data;
	}
	public BSTNode(Integer data, int lst_size) {
		this.data = data;
		this.lst_size = lst_size;
	}
	
}

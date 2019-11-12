package com.alg.top20.bst;

public class TreeNode {
	TreeNode left;
	TreeNode right;
	int data;
	int lst_size;

	public TreeNode() {

	}

	public TreeNode(int data) {
		this.data = data;
	}
	
	public TreeNode(int data, int rank) {
		this.data = data;
		this.lst_size = rank;
	}
}

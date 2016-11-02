package com.alg.top20.set;

public class BSTNode {
	Integer data;
	BSTNode left;
	BSTNode right;
	int lst_size;
	
	public BSTNode(Integer data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "BSTNode [data=" + data + ", lst_size=" + lst_size + "]";
	}
	
	

}

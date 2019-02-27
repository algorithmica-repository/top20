package com.alg.top20.bst;

public class Search {

	//TC:O(log n)   SC:O(1)	
	public static boolean search(BSTNode root, int x) {
		BSTNode current = root;
		while (current != null) {
			if (x == current.data)
				return true;
			if (x < current.data)
				current = current.left;
			else
				current = current.right;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package com.alg.top20.bbst;
public class SearchBBST {

	public static boolean search1(BSTNode root, int x) {
		while (root != null) {
			if (x == root.data)
				return true;
			if (x < root.data)
				root = root.left;
			else
				root = root.right;
		}
		return false;
	}
	
	public static boolean search2(BSTNode root, int x) {
		if(root == null) return false;
		if(x == root.data) return true;
		if(x < root.data)
			return search2(root.left, x);
		else
			return search2(root.right, x);
	}
}

package com.alg.top20.bbst;

public class SearchBBST {

	public static boolean search(TreeNode root, int x) {
		while(root != null) {
			if(x == root.data) return true;
			if(x < root.data) root = root.left;
			else root = root.right;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

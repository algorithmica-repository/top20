package com.alg.top20.bst;

public class BSTSearch {

	//TC:O(h)  SC:O(1)
	//precondition: input tree must be bst
	public static boolean search1(TreeNode root, int x) {
		while (root != null) {
			if (root.data == x)
				return true;
			if (x < root.data)
				root = root.left;
			else
				root = root.right;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

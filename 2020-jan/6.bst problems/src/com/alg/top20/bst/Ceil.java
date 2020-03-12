package com.alg.top20.bst;

public class Ceil {

	// TC:O(h) SC:O(1)
	public static int ceil1(TreeNode root, int x) {
		int res = Integer.MIN_VALUE;
		while (root != null) {
			if (root.data == x)
				return x;
			if (x < root.data) {
				res = root.data;
				root = root.left;
			} else
				root = root.right;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

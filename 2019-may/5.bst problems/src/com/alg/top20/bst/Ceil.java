package com.alg.top20.bst;

public class Ceil {

	public static Integer ceil1(BSTNode root, int x) {
		if (root == null)
			return null;
		Integer left = ceil1(root.left, x);
		if (left != null)
			return left;
		if (root.data >= x)
			return root.data;
		return ceil1(root.right, x);
	}

	public static Integer ceil2(BSTNode root, int x) {
		int res = Integer.MIN_VALUE;
		while (root != null) {
			if (root.data == x)
				return root.data;
			if (root.data > x) {
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

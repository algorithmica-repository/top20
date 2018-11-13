package com.alg.top20.bst;

public class Selection {

	public static int kthSmallest1(TreeNode root, int k) {
		MyInteger counter = new MyInteger(0);
		TreeNode res = auxSmallest1(root, k, counter);
		if (res == null)
			return Integer.MIN_VALUE;
		return res.data;
	}

	private static TreeNode auxSmallest1(TreeNode root, int k, MyInteger counter) {
		if (root == null)
			return null;
		TreeNode res = auxSmallest1(root.left, k, counter);
		if (res != null)
			return res;
		counter.set(counter.get() + 1);
		if (counter.get() == k)
			return root;
		return auxSmallest1(root.right, k, counter);
	}

	public static int kthSmallest2(TreeNode root, int k) {
		while (root != null) {
			if (k == root.ls_size)
				return root.data;
			if (k < root.ls_size) {
				root = root.left;
			} else {
				root = root.right;
				k = k - root.ls_size;
			}
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

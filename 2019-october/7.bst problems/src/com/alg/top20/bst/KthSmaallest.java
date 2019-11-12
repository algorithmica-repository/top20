package com.alg.top20.bst;

import java.util.Random;

public class KthSmaallest {

	public static int kthSmallest1(TreeNode root, int k) {
		MyInteger counter = new MyInteger(0);
		TreeNode res = auxSmallest(root, k, counter);
		return res == null ? Integer.MIN_VALUE : res.data;
	}

	private static TreeNode auxSmallest(TreeNode root, int k, MyInteger counter) {
		if (root == null)
			return null;
		TreeNode res = auxSmallest(root.left, k, counter);
		if (res != null)
			return res;
		counter.incr();
		//System.out.println(root.data + ":" + counter.get());
		if (counter.get() == k)
			return root;
		return auxSmallest(root.right, k, counter);
	}

	public static int kthSmallest2(TreeNode root, int k) {
		while (root != null) {
			if (k == root.lst_size + 1)
				return root.data;
			if (k < root.lst_size + 1)
				root = root.left;
			else {
				k = k - (root.lst_size + 1);
				root = root.right;
			}
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BSTUtils.createUniqueBST(n);
		BSTUtils.displayTree(root);
		int k = new Random(0).nextInt(n) + 1;
		System.out.println(k);
		System.out.println(kthSmallest1(root, k));
		System.out.println(kthSmallest2(root, k));
	}

}

package com.alg.top20.bst;

public class Selection {

	// TC:O(n) SC:O(log n)
	public static int selection1(BSTNode root, int k) {
		MyInteger counter = new MyInteger(0);
		BSTNode res = auxSelection1(root, counter, k);
		if (res == null)
			return Integer.MIN_VALUE;
		return res.data;
	}

	private static BSTNode auxSelection1(BSTNode root, MyInteger counter, int k) {
		if (root == null)
			return null;
		BSTNode tmp = auxSelection1(root.left, counter, k);
		if (tmp != null)
			return tmp;
		counter.increment(1);
		if (counter.get() == k)
			return root;
		return auxSelection1(root.right, counter, k);
	}

	// TC:O(log n) SC:O(n)
	public static int selection2(BSTNode root, int k) {
		BSTNode current = root;
		while (current != null) {
			if (current.local_rank == k)
				return current.data;
			if (k < current.local_rank)
				current = current.left;
			else {
				k = k - current.local_rank;
				current = current.right;
			}
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BSTNode root = BSTUtils.createUniqueBST(n);
		BSTUtils.displayTree(root);
		int k = n/2;
		System.out.println(selection1(root, k));
		System.out.println(selection2(root, k));

	}

}

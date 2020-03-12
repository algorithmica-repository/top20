package com.alg.top20.bst;

import java.util.Random;

public class Floor {

	public static int floor(TreeNode root, int x) {
		int res = Integer.MIN_VALUE;
		while (root != null) {
			if (x == root.data)
				return root.data;
			if (x < root.data)
				root = root.left;
			else {
				res = root.data;
				root = root.right;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BSTUtils.createBBST(n);
		BSTUtils.displayTree(root);
		int x = new Random().nextInt(100)+1;
		System.out.println(x);
		System.out.println(floor(root, x));
	}

}

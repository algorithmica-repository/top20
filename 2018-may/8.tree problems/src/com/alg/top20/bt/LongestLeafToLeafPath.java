package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class LongestLeafToLeafPath {
	
	public static int longestLeafToLeaf1(TreeNode root) {
		MyInteger max = new MyInteger(Integer.MIN_VALUE);
		auxLeafToLeaf1(root, max);
		return max.get();
	}
	private static int auxLeafToLeaf1(TreeNode root, MyInteger max) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int lp = auxLeafToLeaf1(root.left, max);
		int rp = auxLeafToLeaf1(root.right, max);
		max.set(Math.max(max.get(), lp+rp+1));
		return Math.max(lp, rp) + 1;
	}

	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		System.out.println(longestLeafToLeaf1(root));
	}

}

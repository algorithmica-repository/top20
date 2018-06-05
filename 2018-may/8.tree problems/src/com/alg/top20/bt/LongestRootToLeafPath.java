package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class LongestRootToLeafPath {
	
	public static int longestRootToLeaf1(TreeNode root) {
		MyInteger max = new MyInteger(Integer.MIN_VALUE);
		auxRootLeaf1(root, 0, max);
		return max.get();
	}
	private static void auxRootLeaf1(TreeNode root, int plength, MyInteger max) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			if(plength+1 > max.get())
				max.set(plength + 1);
			return;
		}
		auxRootLeaf1(root.left, plength+1, max);
		auxRootLeaf1(root.right, plength+1, max);
	}

	public static int longestRootToLeaf2(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int lp = longestRootToLeaf2(root.left);
		int rp = longestRootToLeaf2(root.right);
		return Math.max(lp, rp) + 1;
	}

	public static int longestRootToLeaf3(TreeNode root) {
		int levels = 0;
		if (root == null)
			return levels;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.remove();
			if(tmp == null) {
				++levels;
				if(!queue.isEmpty())
					queue.add(null);
			}
			else {
				if (tmp.left != null)
					queue.add(tmp.left);
				if (tmp.right != null)
					queue.add(tmp.right);
			}
		}
		return levels;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		System.out.println(longestRootToLeaf1(root));
		System.out.println(longestRootToLeaf2(root));
		System.out.println(longestRootToLeaf3(root));
	}

}

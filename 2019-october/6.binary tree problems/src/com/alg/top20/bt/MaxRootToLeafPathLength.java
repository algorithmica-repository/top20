package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class MaxRootToLeafPathLength {
	private static int gmax = 0;

	public static int maxRootToLeafPath11(TreeNode root) {
		auxRooToLeafPath11(root, 1);
		return gmax;
	}

	private static void auxRooToLeafPath11(TreeNode root, int depth) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			gmax = Math.max(gmax, depth);
			return;
		}
		auxRooToLeafPath11(root.left, depth + 1);
		auxRooToLeafPath11(root.right, depth + 1);
	}

	public static int maxRootToLeafPath12(TreeNode root) {
		MyInteger gmax = new MyInteger(0);
		auxRooToLeafPath12(root, 1, gmax);
		return gmax.get();
	}

	private static void auxRooToLeafPath12(TreeNode root, int depth, MyInteger gmax) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			gmax.set(Math.max(gmax.get(), depth));
			return;
		}
		auxRooToLeafPath12(root.left, depth + 1, gmax);
		auxRooToLeafPath12(root.right, depth + 1, gmax);
	}

	public static int maxRootToLeafPath2(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int left = maxRootToLeafPath2(root.left);
		int right = maxRootToLeafPath2(root.right);
		return Math.max(left, right) + 1;
	}

	public static int maxRootToLeafPath3(TreeNode root) {
		int lcount = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			if (tmp == null) {
				++lcount;
				if (!q.isEmpty())
					q.add(null);
			} else {
				if (tmp.left != null)
					q.add(tmp.left);
				if (tmp.right != null)
					q.add(tmp.right);
			}
		}
		return lcount;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		System.out.println(maxRootToLeafPath11(root));
		System.out.println(maxRootToLeafPath12(root));		
		System.out.println(maxRootToLeafPath2(root));
		System.out.println(maxRootToLeafPath3(root));
	}

}

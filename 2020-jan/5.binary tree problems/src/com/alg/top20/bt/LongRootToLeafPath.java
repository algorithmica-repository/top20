package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class LongRootToLeafPath {

	static class MyNode {
		TreeNode node;
		int depth;

		public MyNode(TreeNode node, int depth) {
			super();
			this.node = node;
			this.depth = depth;
		}

	}

	public static int longRootToLeafPath11(TreeNode root) {
		MyInteger gmax = new MyInteger(0);
		auxLongRootToLeafPath11(root, 1, gmax);
		return gmax.get();
	}

	private static void auxLongRootToLeafPath11(TreeNode root, int depth, MyInteger gmax) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			gmax.set(Math.max(gmax.get(), depth));
			return;
		}
		auxLongRootToLeafPath11(root.left, depth + 1, gmax);
		auxLongRootToLeafPath11(root.right, depth + 1, gmax);
	}

	public static int longRootToLeafPath12(TreeNode root) {
		Queue<MyNode> q = new LinkedList<MyNode>();
		q.add(new MyNode(root, 1));
		int res = 0;
		while (!q.isEmpty()) {
			MyNode tmp = q.remove();
			if (tmp.node.left == null && tmp.node.right == null) {
				res = Math.max(res, tmp.depth);
			} else {
				if (tmp.node.left != null)
					q.add(new MyNode(tmp.node.left, tmp.depth + 1));
				if (tmp.node.right != null)
					q.add(new MyNode(tmp.node.right, tmp.depth + 1));
			}
		}
		return res;
	}

	public static int longRootToLeafPath2(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int left = longRootToLeafPath2(root.left);
		int right = longRootToLeafPath2(root.right);
		return Math.max(left, right) + 1;
	}

	public static int longRootToLeafPath3(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		int nlevels = 0;
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			if (tmp == null) {
				++nlevels;
				if (!q.isEmpty())
					q.add(null);
			} else {
				if (tmp.left != null)
					q.add(tmp.left);
				if (tmp.right != null)
					q.add(tmp.right);
			}
		}
		return nlevels;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		System.out.println(longRootToLeafPath11(root));
		System.out.println(longRootToLeafPath12(root));
		System.out.println(longRootToLeafPath2(root));
		System.out.println(longRootToLeafPath3(root));

	}

}

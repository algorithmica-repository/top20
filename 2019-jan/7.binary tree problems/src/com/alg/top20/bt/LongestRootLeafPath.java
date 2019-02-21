package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class LongestRootLeafPath {
	
	// TC:O(n) SC:O(n)
	public static int treeDepth1(BTNode root) {
		MyInteger gmax = new MyInteger(0);
		auxDepth1(root, 1, gmax);
		return gmax.get();
	}
	private static void auxDepth1(BTNode root, int depth, MyInteger gmax) {
		if (root == null) return;
		if (root.left == null && root.right == null) {
			if(depth > gmax.get())
				gmax.set(depth);
			return;
		}
		auxDepth1(root.left, depth+1, gmax);
		auxDepth1(root.right, depth+1, gmax);
	}

	// TC:O(n) SC:O(n)
	public static int treeDepth2(BTNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int ld = treeDepth2(root.left);
		int rd = treeDepth2(root.right);
		return Math.max(ld, rd) + 1;
	}

	// TC:O(n) SC:O(n)
	public static int treeDepth3(BTNode root) {
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		q.add(null);
		int lcount = 0;
		while (!q.isEmpty()) {
			BTNode tmp = q.remove();
			if(tmp == null) {
				++lcount;
				if(!q.isEmpty()) q.add(null);
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
		BTNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		System.out.println(treeDepth1(root));
		System.out.println(treeDepth2(root));
		System.out.println(treeDepth3(root));


	}

}

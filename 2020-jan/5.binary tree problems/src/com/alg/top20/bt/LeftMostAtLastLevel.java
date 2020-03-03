package com.alg.top20.bt;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LeftMostAtLastLevel {
	// TC:O(n) SC:O(n)
	public static int leftMost11(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode tmp = null;
		while (!q.isEmpty()) {
			tmp = q.remove();
			if (tmp.right != null)
				q.add(tmp.right);
			if (tmp.left != null)
				q.add(tmp.left);
		}
		return tmp.data;
	}

	enum state {
		NUllSTATE, NON_NULL_STATE
	}

	// TC:O(n) SC:O(n)
	public static int leftMost12(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		TreeNode tmp = null;
		int res = 0;
		state lastState = state.NUllSTATE;
		while (!q.isEmpty()) {
			tmp = q.remove();
			if (tmp == null) {
				lastState = state.NUllSTATE;
				if (!q.isEmpty())
					q.add(null);
				System.out.println();
			} else {
				if (lastState == state.NUllSTATE) {
					res = tmp.data;
					lastState = state.NON_NULL_STATE;
				}
				System.out.print(tmp.data + " ");
				if (tmp.left != null)
					q.add(tmp.left);
				if (tmp.right != null)
					q.add(tmp.right);
			}
		}
		return res;
	}

	// TC:O(n) SC:O(n)
	public static int leftMost2(TreeNode root) {
		HashMap<Integer, LinkedList<Integer>> hmap = new HashMap<Integer, LinkedList<Integer>>();
		auxleftMost2(root, 1, hmap);
		System.out.println(hmap);
		return hmap.get(hmap.size()).get(0);
	}

	public static void auxleftMost2(TreeNode root, int level, HashMap<Integer, LinkedList<Integer>> hmap) {
		if (root == null) return;
		LinkedList<Integer> values = hmap.get(level);
		if(values == null) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(root.data);
			hmap.put(level, list);
		} else
			values.add(root.data);
		auxleftMost2(root.left, level+1, hmap);
		auxleftMost2(root.right, level+1, hmap);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		System.out.println(leftMost2(root));
	}

}

package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSize {

	// TC:O(n) SC:O(n)
	public static int treeSize1(BTNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int ls = treeSize1(root.left);
		int rs = treeSize1(root.right);
		return ls + rs + 1;
	}

	// TC:O(n) SC:O(n)
	public static int treeSize2(BTNode root) {
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		int count = 0;
		while (!q.isEmpty()) {
			BTNode tmp = q.remove();
			++count;
			if (tmp.left != null)
				q.add(tmp.left);
			if (tmp.right != null)
				q.add(tmp.right);
		}
		return count;
	}

	// TC:O(n) SC:O(1)
	public static int treeSize3(BTNode root) {
		BTNode current = root, tmp;
		int count = 0;

		while (current != null) {
			if (current.left == null) {
				current = current.right;
				++count;
			} else {
				//find inorder predessor
				tmp = current.left;
				while (tmp.right != null && tmp.right != current)
					tmp = tmp.right;
				//is the node visited for first time?
				if (tmp.right == null) {
					tmp.right = current;
					current = current.left;
					++count;
				} else {
					tmp.right = null;
					current = current.right;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BTNode root = BinaryTreeUtils.createOneSidedBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		System.out.println(treeSize1(root));
		System.out.println(treeSize2(root));
		System.out.println(treeSize3(root));

	}

}

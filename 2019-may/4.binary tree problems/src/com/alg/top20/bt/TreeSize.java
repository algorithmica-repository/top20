package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSize {

	public static int treeSize1(BTNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int ls = treeSize1(root.left);
		int rs = treeSize1(root.right);
		return ls + rs + 1;
	}

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
	private static BTNode inorder_predecessor(BTNode p) {
		BTNode current = p;
		p = p.left;
		while(p.right != null && p.right != current)
			p = p.right;
		return p;
	}
	public static int treeSize3(BTNode root) {
		int count = 0;
		while (root != null) {
			//Is Left subtree exist?
			if (root.left != null) {
				BTNode tmp = inorder_predecessor(root);
				//should we visit left or right subtree?
				if (tmp.right == null) {
					tmp.right = root;
					root = root.left;
					++count;
				} else {
					tmp.right = null;
					root = root.right;
				}
			} else {
				root = root.right;
				++count;
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

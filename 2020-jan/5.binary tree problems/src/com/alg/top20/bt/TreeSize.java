package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSize {

	public static int treeSize1(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int ls = treeSize1(root.left);
		int rs = treeSize1(root.right);
		return ls + rs + 1;
	}

	public static int treeSize2(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int count = 0;
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			++count;
			if (tmp.left != null)
				q.add(tmp.left);
			if (tmp.right != null)
				q.add(tmp.right);
		}
		return count;
	}
	private static TreeNode inorder_predecessor(TreeNode p) {
		TreeNode current = p;
		p = p.left;
		while(p.right != null && p.right != current)
			p = p.right;
		return p;
	}
	public static int treeSize3(TreeNode root) {
		int count = 0;
		while (root != null) {
			if (root.left != null) {
				TreeNode tmp = inorder_predecessor(root);
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
		// TODO Auto-generated method stub

	}

}

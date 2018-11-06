package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSize {

	public static int treeSize1(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int lsize = treeSize1(root.left);
		int rsize = treeSize1(root.right);
		return lsize + rsize + 1;
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

	public static int treeSize3(TreeNode root) {
		int count = 0;
		while (root != null) {
			//if left child doesnot exist for current node, no book-keeping operations required
			if (root.left == null) {
				++count;
				root = root.right;
			} else {
				//find inorder predecessor
				TreeNode tmp = root.left;
				while (tmp.right != null && tmp.right != root)
					tmp = tmp.right;
				//is the predecessor accessed first time?
				if (tmp.right == null) {
					++count;
					tmp.right = root;
					root = root.left;
				} else {
					tmp.right = null;
					root = root.right;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		//BinaryTreeUtils.displayTree2(root);
		System.out.println(treeSize1(root));
		System.out.println(treeSize2(root));
		System.out.println(treeSize3(root));

	}

}

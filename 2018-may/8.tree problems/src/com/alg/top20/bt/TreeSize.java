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
		int count = 0;
		if (root == null)
			return count;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode tmp = queue.remove();
			++count;
			if (tmp.left != null)
				queue.add(tmp.left);
			if (tmp.right != null)
				queue.add(tmp.right);
		}
		return count;
	}

	public static int treeSize3(TreeNode root) {
		int count = 0;
		TreeNode current = root;

		while (current != null) {
			if (current.left == null) {
				current = current.right;
				++count;
			}
			else {
				TreeNode tmp = current.left;
				while (tmp.right != null && tmp.right != current)
					tmp = tmp.right;
				if (tmp.right == null) {
					++count;
					tmp.right = current;
					current = current.left;
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
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		System.out.println(treeSize1(root));
		System.out.println(treeSize2(root));
		System.out.println(treeSize3(root));
	}

}

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
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
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

	private static TreeNode inOrderPredecessor(TreeNode root) {
		TreeNode current = root.left;
		while (current.right != null && current.right != root)
			current = current.right;
		return current;
	}

	public static int treeSize3(TreeNode root) {
		int count = 0;
		while (root != null) {
			if (root.left == null) {
				root = root.right;
				++count;
			}
			else {
				TreeNode tmp = inOrderPredecessor(root);
				//visiting node first time
				if (tmp.right == null) {
					tmp.right = root;
					root = root.left;
					++count;
				} else { //visiting node second time
					tmp.right = null;
					root = root.right;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createOneSidedBinaryTree(n);
		//BinaryTreeUtils.displayTree(root);
		long start = System.currentTimeMillis();
		System.out.println(treeSize2(root));
		long end = System.currentTimeMillis();
		System.out.println("Time:"+ (end-start)/1000.0 + "secs");
		//System.out.println(treeSize2(root));
		//System.out.println(treeSize3(root));

	}
}

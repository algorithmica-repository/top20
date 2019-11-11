package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TreeSearch {

	public static boolean treeSearch1(TreeNode root, int x) {
		if (root == null)
			return false;
		if (root.data == x)
			return true;
		boolean res = treeSearch1(root.left, x);
		if (res == true)
			return true;
		return treeSearch1(root.right, x);
	}
	
	public static boolean treeSearch2(TreeNode root, int x) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			if(tmp.data == x) return true;
			if (tmp.left != null)
				q.add(tmp.left);
			if (tmp.right != null)
				q.add(tmp.right);
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createUniqueBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		int x = new Random().nextInt(n)+1;
		System.out.println(x);
		System.out.println(treeSearch1(root, x));
		System.out.println(treeSearch2(root, x));

	}

}

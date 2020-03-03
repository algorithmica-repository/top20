package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TreeSearch {

	//TC:O(n)  SC:O(n)
	public static boolean treeSearch1(TreeNode root, int x) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return root.data == x;
		if(root.data == x) return true;
		boolean res = treeSearch1(root.left, x);
		if(res == true) return true;
		return treeSearch1(root.right, x);
	}

	//TC:O(n)  SC:O(n)
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

	private static TreeNode inOrderPredecessor(TreeNode root) {
		TreeNode current = root.left;
		while (current.right != null && current.right != root)
			current = current.right;
		return current;
	}
	//TC:O(n)  SC:O(1)
	public static boolean treeSearch3(TreeNode root, int x) {
		while (root != null) {
			if (root.left == null) {
				if(root.data == x) return true;
				root = root.right;
			}
			else {
				TreeNode tmp = inOrderPredecessor(root);
				//visiting node first time
				if (tmp.right == null) {
					tmp.right = root;
					if(root.data == x) return true;
					root = root.left;
				} else { //visiting node second time
					tmp.right = null;
					root = root.right;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		int x = new Random().nextInt(n)+1;
		System.out.println(x);
		//long start = System.currentTimeMillis();
		System.out.println(treeSearch1(root, x));
		System.out.println(treeSearch2(root, x));
		System.out.println(treeSearch3(root, x));

		//long end = System.currentTimeMillis();
		//System.out.println("Time:"+ (end-start)/1000.0 + "secs");
		//System.out.println(treeSize2(root));
		//System.out.println(treeSize3(root));

	}
}


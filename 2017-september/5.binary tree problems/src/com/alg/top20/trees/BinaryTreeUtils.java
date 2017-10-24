package com.alg.top20.trees;

import java.util.Random;

public class BinaryTreeUtils {

	private static TreeNode add(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);
		Random r = new Random();
		TreeNode current = root;
		while (true) {
			if (r.nextInt(2) == 0) {
				if (current.left == null) {
					current.left = new TreeNode(data);
					break;
				} else {
					current = current.left;
				}
			} else {
				if (current.right == null) {
					current.right = new TreeNode(data);
					break;
				} else {
					current = current.right;
				}
			}
		}
		return root;
	}

	public static TreeNode createTree(int n) {
		TreeNode root = null;
		Random r = new Random(100);
		for (int i = 0; i < n; ++i)
			root = add(root, r.nextInt(n)+1);
		return root;
	}
	public static TreeNode createTree2(int n) {
		TreeNode root = null;
		for (int i = 0; i < n; ++i)
			root = add(root, i+1);
		return root;
	}

	// TC:O(n ^ 2)
	// SC:O(n)
	public static void display1(TreeNode root) {
		auxDisplay1(root, 0, "root");
	}

	private static void auxDisplay1(TreeNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.data + "(" + type + ")");
		auxDisplay1(root.left, nspaces + 4, "L");
		auxDisplay1(root.right, nspaces + 4, "R");
	}

}

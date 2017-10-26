package com.alg.top20.bst;

import java.util.Random;

public class BSTUtils {
	
	//TC:O(h)
	//SC:O(1)
	private static TreeNode add(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);
		TreeNode current = root;
		TreeNode parent = null;
		while(current != null) {
			parent = current;
			if(data < current.data) {
				++current.ls_size;
				current = current.left;
			}
			else
				current = current.right;
		}
		if(data < parent.data)
			parent.left = new TreeNode(data);
		else
			parent.right = new TreeNode(data);
		return root;
	}

	public static TreeNode createBST(int n) {
		TreeNode root = null;
		Random r = new Random();
		for (int i = 0; i < n; ++i)
			root = add(root, r.nextInt(n)+1);
		return root;
	}
	
	//TC:O(n)
	//SC:O(log n)
	//build bbst from sorted input
	public static TreeNode createBBST(int n) {
		return auxBBST(1, n);
	}
	private static TreeNode auxBBST(int l, int r) {
		if(l > r) return null;
		//if(l == r) return new TreeNode(l);
		int m = (l + r)/2;
		TreeNode tmp = new TreeNode(m);
		tmp.left = auxBBST(l, m-1);
		tmp.right = auxBBST(m+1, r);
		return tmp;
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
		System.out.println(root.data + "(" + root.ls_size + "," + type + ")");
		auxDisplay1(root.left, nspaces + 4, "L");
		auxDisplay1(root.right, nspaces + 4, "R");
	}

}

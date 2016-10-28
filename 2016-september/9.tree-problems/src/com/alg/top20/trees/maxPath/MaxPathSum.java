package com.alg.top20.trees.maxPath;

import com.alg.top20.trees.size.TreeNode;

public class MaxPathSum {
	
	private static int max = Integer.MIN_VALUE;
	
	//Exploration of all paths in binary tree O(n)
	private static void auxMaxPath1(TreeNode root, int csum) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			max = Math.max(max, root.data + csum);
			return;
		}
		auxMaxPath1(root.left, root.data + csum);
		auxMaxPath1(root.right, root.data + csum);
	}
	
	public static int findMaxPath1(TreeNode root) {
		auxMaxPath1(root, 0);
		return max;
	}
	
	//Use recursion to divide into subproblems and then build solution
	public static int findMaxPath2(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) {
			return root.data;
		}
		int lmax = findMaxPath2(root.left);
		int rmax = findMaxPath2(root.right);
		return Math.max(lmax, rmax) + root.data;
	}

}

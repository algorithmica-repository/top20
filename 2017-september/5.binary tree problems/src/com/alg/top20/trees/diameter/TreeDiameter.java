package com.alg.top20.trees.diameter;

import com.alg.top20.trees.BinaryTreeUtils;
import com.alg.top20.trees.MyInteger;
import com.alg.top20.trees.TreeNode;

public class TreeDiameter {

	//TC:O(n)
	//SC:O(n)
	public static int findLongestLeafToLeafPath(TreeNode root) {
		MyInteger diameter = new MyInteger(Integer.MIN_VALUE);
		auxLeafToLeafPath(root, diameter);
		return diameter.get();
	}
	private static int auxLeafToLeafPath(TreeNode root, MyInteger diameter) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int left = auxLeafToLeafPath(root.left, diameter);
		int right = auxLeafToLeafPath(root.right, diameter);
		diameter.set(Math.max(diameter.get(), left + right + 1));
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createTree(n);
		BinaryTreeUtils.display1(root);
		System.out.println(findLongestLeafToLeafPath(root));
	}
}

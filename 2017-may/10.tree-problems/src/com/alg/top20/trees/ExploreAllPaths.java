package com.alg.top20.trees;

public class ExploreAllPaths {
	
	public static void explorePaths1(TreeNode root) {
		auxPaths(root, "");
	}
	private static void auxPaths(TreeNode root, String prefix) {
		if(root == null) return;
		if(root.left == null  && root.right == null) {
			System.out.println(prefix+root.data);
			return;
		}
		auxPaths(root.left, prefix+root.data+"-");
		auxPaths(root.right, prefix+root.data+"-");
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		explorePaths1(root);
	}
}

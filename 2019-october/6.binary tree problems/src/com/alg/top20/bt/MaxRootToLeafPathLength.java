package com.alg.top20.bt;

public class MaxRootToLeafPathLength {
	private static int gmax = 0;
	public static int maxRootToLeafPath1(TreeNode root) {
		auxRooToLeafPath1(root, 1);
		return gmax;
	}
	private static void auxRooToLeafPath1(TreeNode root, int depth) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			gmax = Math.max(gmax, depth);
			return;
		}
		auxRooToLeafPath1(root.left, depth+1);
		auxRooToLeafPath1(root.right, depth+1);
	}
	
	public static int maxRootToLeafPath2(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int left = maxRootToLeafPath2(root.left);
		int right = maxRootToLeafPath2(root.right);
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		System.out.println(maxRootToLeafPath1(root));
		System.out.println(maxRootToLeafPath2(root));
	}

}

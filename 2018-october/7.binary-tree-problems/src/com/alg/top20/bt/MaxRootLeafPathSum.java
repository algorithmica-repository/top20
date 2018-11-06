package com.alg.top20.bt;

public class MaxRootLeafPathSum {
	static int gmax = Integer.MIN_VALUE;
	public static int maxPathSum11(TreeNode root) {
		auxPathSum11(root, 0);
		return gmax;
	}
	
	private static void auxPathSum11(TreeNode root, int csum) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			gmax = Math.max(gmax, csum + root.data);
			return;
		}
		auxPathSum11(root.left, csum + root.data);
		auxPathSum11(root.right, csum + root.data);
	}
	
	public static int maxPathSum12(TreeNode root) {
		MyInteger max = new MyInteger(Integer.MIN_VALUE);
		auxPathSum12(root, 0, max);
		return max.get();
	}
	
	private static void auxPathSum12(TreeNode root, int csum, MyInteger max) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			max.set(Math.max(max.get(), csum + root.data));
			return;
		}
		auxPathSum12(root.left, csum + root.data, max);
		auxPathSum12(root.right, csum + root.data, max);
	}
	
	public static int maxPathSum2(TreeNode root) {
		if(root == null) return Integer.MIN_VALUE;
		if(root.left == null && root.right == null) return root.data;
		int left = maxPathSum2(root.left);
		int right = maxPathSum2(root.right);
		return Math.max(left, right) + root.data;	
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createOneSidedBinaryTree(n);
		//BinaryTreeUtils.displayTree2(root);
		System.out.println(maxPathSum11(root));
		System.out.println(maxPathSum12(root));
		System.out.println(maxPathSum2(root));
	}

}

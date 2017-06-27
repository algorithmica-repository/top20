package com.alg.top20.trees;

public class LongestRootLeafPathSum {
	
	//TC:O(n)   SC:O(n)
	public static int maxPathSum1(TreeNode root) {
		MyInteger maxSum = new MyInteger();
		auxPathSum1(root, 0, maxSum);
		return maxSum.get();
	}
	private static void auxPathSum1(TreeNode root, int prefix, MyInteger maxSum) {
		if(root == null) return;
		if(root.left == null  && root.right == null) {
			maxSum.set(Math.max(maxSum.get(), prefix+root.data));
			return;
		}
		auxPathSum1(root.left, prefix+root.data, maxSum);
		auxPathSum1(root.right, prefix+root.data, maxSum);
	}
	
	public static int maxPathSum2(TreeNode root) {
		if(root == null) return 0;
		int ls = maxPathSum2(root.left);
		int rs = maxPathSum2(root.right);
		return Math.max(ls, rs) + root.data;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		System.out.println(maxPathSum2(root));
	}

}

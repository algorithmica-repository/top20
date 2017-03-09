package com.alg.top20.trees;

public class MaxPathSum {
	private static int maxSum = Integer.MIN_VALUE;

	public static int maxPathSum1(BTreeNode root) {
		auxPathSum1(root, 0);
		return maxSum;
	}
	private static void auxPathSum1(BTreeNode current, int csum) {
		if(current == null) return;
		if(current.left == null && current.right == null) {
			System.out.println(csum + current.data);
			maxSum = Math.max(maxSum, csum + current.data);
			return;
		}
		auxPathSum1(current.left, csum + current.data );
		auxPathSum1(current.right, csum + current.data );
	}
	static class MyResult {
		int maxsum;
	}
	
	//to avoid static maxsum(problematic across threads)
	public static int maxPathSum2(BTreeNode root) {
		MyResult result = new MyResult();
		auxPathSum2(root, 0, result);
		return result.maxsum;
	}
	private static void auxPathSum2(BTreeNode current, int csum, MyResult result) {
		if(current == null) return;
		if(current.left == null && current.right == null) {
			System.out.println(csum + current.data);
			result.maxsum = Math.max(result.maxsum, csum + current.data);
			return;
		}
		auxPathSum2(current.left, csum + current.data,result );
		auxPathSum2(current.right, csum + current.data, result );
	}
	
	public static int maxPathSum3(BTreeNode root) {
		if(root== null) return 0;		
		int lpsum = maxPathSum3(root.left);
		int rpsum = maxPathSum3(root.right);
		return Math.max(lpsum, rpsum) + root.data;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		RBinaryTree tree = new RBinaryTree();
		BTreeNode root = tree.randomTree(n);
		tree.display();
		System.out.println(maxPathSum1(root));
		System.out.println(maxPathSum3(root));
	}

}

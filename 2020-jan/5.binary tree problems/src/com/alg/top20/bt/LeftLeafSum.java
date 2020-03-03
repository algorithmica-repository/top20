package com.alg.top20.bt;

public class LeftLeafSum {

	public static int leafSum1(TreeNode root) {
		return auxSum1(root, false);
	}

	private static int auxSum1(TreeNode root, boolean isLeft) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			if(isLeft) return root.data;
			else return 0;
		}
		int ls = auxSum1(root.left, true);
		int rs = auxSum1(root.right, false);
		return ls + rs;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		System.out.println(leafSum1(root));
	}

}
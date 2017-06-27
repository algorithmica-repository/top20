package com.alg.top20.trees;

public class LongestLeaftToLeafPath {

	public static int treeDiameter1(TreeNode root) {
		MyInteger diameter = new MyInteger();
		auxDiameter1(root, diameter);
		return diameter.get();
	}
	private static int auxDiameter1(TreeNode root, MyInteger diameter) {
		if(root == null) return 0;
		int lh = auxDiameter1(root.left, diameter);
		int rh = auxDiameter1(root.right, diameter);
		diameter.set(Math.max(diameter.get() ,lh + rh + 1));
		return Math.max(lh, rh) + 1;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		System.out.println(treeDiameter1(root));
	}

}

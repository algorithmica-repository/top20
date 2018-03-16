package com.alg.top20.bt;

public class TreeDiameter {

	public static int treeDiameter1(TreeNode root) {
		MyInteger diameter = new MyInteger(Integer.MIN_VALUE);
		height(root, diameter);
		return diameter.get();
	}
	private static int height(TreeNode root, MyInteger diameter) {
		if(root == null) return 0;		
		int lh = height(root.left, diameter);
		int rh = height(root.right, diameter);
		diameter.set(Math.max(diameter.get(), lh + rh + 1));
		return Math.max(lh, rh) + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

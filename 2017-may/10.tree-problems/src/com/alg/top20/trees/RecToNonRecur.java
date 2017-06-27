package com.alg.top20.trees;
public class RecToNonRecur {
	
	public static void template1R(TreeNode root) {
		System.out.println(root.data);
		template1R(root.left);
		template1R(root.right);
	}
	
	public static void template1NR(TreeNode root) {
		
	}
	
}

package com.alg.top20.bst.balancecheck;

import com.alg.top20.bst.BSTUtils;
import com.alg.top20.bst.TreeNode;

public class IsBalancedBST {
	
	//TC:O(n log n)
	//SC:O(log n)
	public static boolean isBalanced1(TreeNode root) {
		//TODO: fill up the logic
		return true;
	}
	
	//TC:O(n)
	//SC:O(n) -> O(1)
	public static boolean isBalanced2(TreeNode root) {;
		if(auxBalanced2(root) == -1)
			return false;
		return true;
	}
	private static int auxBalanced2(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int lh = auxBalanced2(root.left);
		if(lh == -1) return -1;
		int rh = auxBalanced2(root.right);
		if(rh == -1) return -1;
		if(Math.abs(lh-rh) > 1) return -1;
		return Math.max(lh, rh) + 1;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BSTUtils.createBST(n);
		BSTUtils.display1(root);
		System.out.println(isBalanced2(root));

	}

}

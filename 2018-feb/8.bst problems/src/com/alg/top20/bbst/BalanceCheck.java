package com.alg.top20.bbst;

public class BalanceCheck {

	//TC:O(n) SC:O(n)
	public static boolean isBalanced(BSTNode root) {
		return auxBalanced(root) != -1;
	}
	
	
	private static int auxBalanced(BSTNode root) {
		if(root == null) return 0;
		int lh = auxBalanced(root.left);
		if(lh == -1) return -1;
		int rh = auxBalanced(root.right);
		if(rh == -1) return -1;
		if(Math.abs(lh-rh)>1) return -1;
		return Math.max(lh, rh) + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

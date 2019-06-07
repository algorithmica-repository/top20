package com.alg.top20.bt;

public class LeftLeafSum {

	public static int leftLeafSum1(BTNode root) {
		return auxleftLeafSum1(root, ' ');
	}
	private static int auxleftLeafSum1(BTNode root, char label) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			if(label =='L') return root.data;
			return 0;
		}
		int ls = auxleftLeafSum1(root.left, 'L');
		int rs = auxleftLeafSum1(root.right, 'R');
		return ls + rs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

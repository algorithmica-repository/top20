package com.alg.top20.bt;

public class LeftLeafSum {
	public static int leafSum11(TreeNode root) {
		return auxSum11(root, null);
	}

	private static int auxSum11(TreeNode root, TreeNode parent) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null && parent != null) {
			if(parent.left == root) return root.data;
			else return 0;
		}
		int ls = auxSum11(root.left, root);
		int rs = auxSum11(root.right, root);
		return ls + rs;
	}

	public static int leafSum12(TreeNode root) {
		return auxSum12(root, ' ');
	}

	private static int auxSum12(TreeNode root, char type) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			if(type =='L') return root.data;
			else return 0;
		}
		int ls = auxSum12(root.left, 'L');
		int rs = auxSum12(root.right, 'R');
		return ls + rs;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		System.out.println(leafSum11(root));
		System.out.println(leafSum12(root));
	}

}

package com.alg.top20.bst;

public class SerDe {

	public static String ser1(BSTNode root) {
		StringBuilder sb = new StringBuilder();
		auxSer1(root, sb);
		return sb.toString();
	}
	private static void auxSer1(BSTNode root, StringBuilder sb) {
		if(root == null) return ;
		sb.append(root.data +",");
		auxSer1(root.left, sb);
		auxSer1(root.right, sb);
	}
	
	public static BSTNode deser1(String in) {
		String[] tokens = in.split(",");
		BSTNode root = null;
		for(String token: tokens) {
			int x = Integer.parseInt(token);
			root = BSTUtils.add(root, x);
		}
		return root;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BSTNode root = BSTUtils.createUniqueBST(n);
		BSTUtils.displayTree(root);
		String tmp = ser1(root);
		System.out.println(tmp);
		root = deser1(tmp);
		BSTUtils.displayTree(root);
	}

}

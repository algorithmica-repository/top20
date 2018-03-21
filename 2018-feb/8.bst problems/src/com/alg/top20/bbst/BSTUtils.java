package com.alg.top20.bbst;

import java.util.Random;

public class BSTUtils {

	public static BSTNode generateBBST_incr(int n) {
		Random r = new Random();
		BSTNode root = null;
		for(int i = 0; i < n; ++i) {
			int x = r.nextInt(2*n) + 1;
			root = add(root, x);
		}
		return root;
	}
	//todo: build bst and maintain balance with rotations
	private static BSTNode add(BSTNode root, int x) {
		return null;
	}
	public static BSTNode generateBBST(int n) {
		return auxBBST(1, n);
	}
	private static BSTNode auxBBST(int l, int r) {
		if(l > r) return null;
		int m = l + (r-l)/2;
		BSTNode tmp = new BSTNode(m);
		tmp.lst_size = m - l;
		tmp.left = auxBBST(l, m-1);
		tmp.right = auxBBST(m+1, r);
		return tmp;
	}
	
	public static void display(BSTNode root) {
		auxDisplay(root, 0, 'R');
	}
	private static void auxDisplay(BSTNode root, int nspaces, char type) {
		if(root == null) return;
		for(int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println("(" + root.data + "," + root.lst_size + "," + type + ")");
		auxDisplay(root.left, nspaces + 4, 'L');		
		auxDisplay(root.right, nspaces + 4, 'R');
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BSTNode root = generateBBST(n);
		display(root);

	}

}

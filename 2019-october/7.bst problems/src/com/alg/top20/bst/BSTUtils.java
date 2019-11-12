package com.alg.top20.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Result1 {
	TreeNode node;
	int ls_size;
	public Result1(TreeNode node, int ls_size) {
		super();
		this.node= node;
		this.ls_size = ls_size;
	}

}
public class BSTUtils {

	public static TreeNode createBBST(int n) {
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = i+1;
		return auxBBST(in, 0, in.length-1);
	}
	private static TreeNode auxBBST(int[] in, int l, int r) {
		if(l > r) return null;
		int m = l + (r-l)/2;
		TreeNode tmp = new TreeNode(in[m], m-l+1);
		tmp.left = auxBBST(in, l, m-1);
		tmp.right = auxBBST(in, m+1, r);
		return tmp;
	}	
	
	public static TreeNode add(TreeNode root, int data) {
		if(root == null) return new TreeNode(data);
		if(data == root.data) return root;
		else if(data < root.data) {
			++root.lst_size;
			root.left = add(root.left, data);
		}
		else
			root.right = add(root.right, data);
		return root;		
	}
	public static TreeNode createUniqueBST(int n) {
		TreeNode root = null;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= n; ++i)
			list.add(i);
		Collections.shuffle(list);
		//System.out.println(list);
		for(Integer x: list)
			root = add(root, x);	
		return root;
	}
	
	public static void displayTree(TreeNode root) {
		auxDisplay(root, 0, "Root");
	}
	private static void auxDisplay(TreeNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.data + "(" + type + "," + root.lst_size + ")");
		auxDisplay(root.left, nspaces + 4, "L");
		auxDisplay(root.right, nspaces + 4, "R");
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = createUniqueBST(n);
		displayTree(root);
	}

}

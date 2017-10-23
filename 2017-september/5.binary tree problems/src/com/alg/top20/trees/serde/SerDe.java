package com.alg.top20.trees.serde;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.alg.top20.trees.TreeNode;

public class SerDe {

	private static void preorder(TreeNode root, List<Integer> tmp) {
		if(root == null) return;
		tmp.add(root.data);
		preorder(root.left, tmp);
		preorder(root.right, tmp);
	}
	
	private static void inorder(TreeNode root, List<Integer> tmp) {
		if(root == null) return;
		inorder(root.left, tmp);
		tmp.add(root.data);
		inorder(root.right, tmp);
	}
	//TC:O(n)
	//SC:O(n) -> O(1)
	public static void serialize1(TreeNode root, int[] pre, int[] in) {
		 List<Integer> tmp = new LinkedList<Integer>();
		 preorder(root, tmp);
		 tmp.clear();
		 inorder(root, tmp);
	}
	public static TreeNode deserialize1(int[] pre, int[] in) {
		return null;
	}
	
	//TC:O(n)
	//SC:O(n)
	public static void serialize2(TreeNode root, int[] level) {
		
	}
	public static TreeNode deserialize2(int[] level) {
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

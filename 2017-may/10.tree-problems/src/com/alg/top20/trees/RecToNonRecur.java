package com.alg.top20.trees;

import java.util.Stack;

class Frame {
	TreeNode ref;
	boolean flag;	
	public Frame(TreeNode ref, boolean flag) {
		super();
		this.ref = ref;
		this.flag = flag;
	}	
}
public class RecToNonRecur {

	public static void template0R(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		if (root.data % 2 == 0)
			template0R(root.left);
		else
			template0R(root.right);
	}

	public static void template0NR(TreeNode root) {
		while (root != null) {
			System.out.print(root.data + " ");
			if (root.data % 2 == 0)
				root = root.left;
			else
				root = root.right;
		}
	}

	// TC:O(n) SC:O(n)
	public static void template1R(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		template1R(root.left);
		template1R(root.right);
	}

	// TC: n * 2 * O(1) ~ O(n)
	// SC:O(n)
	public static void template1NR(TreeNode root) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		while (true) {
			while (root != null) {
				System.out.print(root.data + " ");
				st.push(root);
				root = root.left;
			}
			if (st.empty())
				break;
			root = st.pop().right;
		}
	}
	
	// TC:O(n) SC:O(n)
	public static void template2R(TreeNode root) {
		if (root == null)
			return;		
		template2R(root.left);
		template2R(root.right);
		System.out.print(root.data + " ");
	}

	// TC: n * 2 * O(1) ~ O(n)
	// SC:O(n)
	public static void template2NR(TreeNode root) {
		Stack<Frame> st = new Stack<Frame>();
		while (true) {
			while (root != null) {
				st.push(new Frame(root,false));
				root = root.left;
			}
			if (st.empty())
				break;
			if(st.peek().flag == true) {
			  System.out.print(st.pop().ref.data+ " ");
			  root = null;
			} else {
				st.peek().flag = true;
				root = st.peek().ref.right;
			}
		}
	}


	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		template2R(root);
		System.out.println();
		template2NR(root);
	}
}

package com.alg.top20.rec;

import java.util.Stack;

import com.alg.top20.bt.BTNode;
import com.alg.top20.bt.BinaryTreeUtils;

public class Template2 {

	public static void f_rec(BTNode root) {
		if (root == null)
			return;
		System.out.println(root.data);
		f_rec(root.left);
		f_rec(root.right);
	}

	public static void f_nonrec(BTNode root) {
		Stack<BTNode> st = new Stack<BTNode>();
		while (true) {
			while (root != null) {
				st.push(root);
				System.out.println(root.data);
				root = root.left;
			}
			if (st.isEmpty())
				break;
			root = st.pop().right;
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BTNode root = BinaryTreeUtils.createOneSidedBinaryTree(n);
		//BinaryTreeUtils.displayTree(root);
		f_rec(root);
		System.out.println();
		f_nonrec(root);
	}
}

package com.alg.top20.rec;

import java.util.Stack;

import com.alg.top20.bt.BTNode;
import com.alg.top20.bt.BinaryTreeUtils;

public class Template4 {

	public static void f_rec(BTNode root) {
		if (root == null)
			return;
		f_rec(root.left);
		f_rec(root.right);
		System.out.println(root.data);
	}

	static class Entry {
		BTNode node;
		boolean right_processed;
		public Entry(BTNode node, boolean right_processed) {
			super();
			this.node = node;
			this.right_processed = right_processed;
		}
		
	}
	public static void f_nonrec(BTNode root) {
		Stack<Entry> st = new Stack<Entry>();
		while (true) {
			while (root != null) {
				st.push(new Entry(root, false) );
				root = root.left;
			}
			if (st.isEmpty())
				break;
			Entry tmp = st.peek();
			if(tmp.right_processed == false) {
				root = tmp.node.right;
				tmp.right_processed = true;
			} else {
				tmp = st.pop();
				System.out.println(tmp.node.data);
				root = null;
			}
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BTNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		f_rec(root);
		System.out.println();
		f_nonrec(root);
	}
}

package com.alg.top20.trees;

import java.util.Stack;

public class RecNonRecTranf {

	public static int bsearchR(int[] in, int l, int r, int x) {
		if (l > r)
			return -1;
		int m = (l + r) / 2;
		if (x == in[m])
			return m;
		if (x < in[m])
			return bsearchR(in, l, m - 1, x);
		else
			return bsearchR(in, m + 1, r, x);
	}

	public static int bsearchNR(int[] in, int l, int r, int x) {
		while (l <= r) {
			int m = (l + r) / 2;
			if (x == in[m])
				return m;
			if (x < in[m])
				r = m - 1;
			else
				l = m + 1;
		}
		return -1;
	}

	public static void preOrderR(TreeNode current) {
		if (current == null)
			return;
		System.out.println(current.data);
		preOrderR(current.left);
		preOrderR(current.right);
	}

	public static void preOrderNR(TreeNode current) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		while (true) {
			while (current != null) {
				System.out.println(current.data);
				st.push(current);
				current = current.left;
			}
			if (st.isEmpty())
				break;
			current = st.pop().right;
		}
	}

	public static void inOrderR(TreeNode current) {
		if (current == null)
			return;
		inOrderR(current.left);
		System.out.println(current.data);
		inOrderR(current.right);
	}

	public static void inOrderNR(TreeNode current) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		while (true) {
			while (current != null) {
				st.push(current);
				current = current.left;
			}
			if (st.isEmpty())
				break;
			current = st.pop();
			System.out.println(current.data);
			current = current.right;
		}
	}

	public static void postOrderR(TreeNode current) {
		if (current == null)
			return;
		postOrderR(current.left);
		postOrderR(current.right);
		System.out.println(current.data);
	}

	static class Entry {
		TreeNode nptr;
		boolean isSecond;

		public Entry(TreeNode nptr) {
			this.nptr = nptr;
			isSecond = false;
		}
	}

	public static void postOrderNR(TreeNode current) {
		Stack<Entry> st = new Stack<Entry>();
		while (true) {
			while (current != null) {
				st.push(new Entry(current));
				current = current.left;
			}
			if (st.isEmpty())
				break;
			Entry tmp = st.peek();
			if (tmp.isSecond) {
				System.out.println(tmp.nptr.data);
				st.pop();
				current = null;
			} else {
				current = tmp.nptr.right;
				tmp.isSecond = true;
			}
		}
	}
}

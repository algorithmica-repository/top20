package com.alg.top20.bbst;
public class Selection {

	public static int kthSmallest11(BSTNode root, int k) {
		MyInteger count = new MyInteger(0);
		BSTNode res = auxSmallest11(root, k, count);
		if (res == null)
			return Integer.MIN_VALUE;
		return res.data;
	}

	private static BSTNode auxSmallest11(BSTNode root, int k, MyInteger count) {
		if (root == null)
			return null;
		BSTNode res = auxSmallest11(root.left, k, count);
		if (res != null)
			return res;
		count.set(count.get() + 1);
		if (count.get() == k)
			return root;
		return auxSmallest11(root.right, k, count);
	}

	public static int kthSmallest12(BSTNode root, int k) {
		int count = 0;
		BSTNode current = root;
		BSTNode res = null;

		while (current != null) {
			if (current.left == null) {
				current = current.right;
				if (++count == k) {
					res = current;
					break;
				}
			} else {
				BSTNode tmp = current.left;
				while (tmp.right != null && tmp.right != current)
					tmp = tmp.right;
				if (tmp.right == null) {
					tmp.right = current;
					current = current.left;
				} else {
					if (++count == k) {
						res = current;
						break;
					}
					tmp.right = null;
					current = current.right;
				}
			}
		}
		if (res == null)
			return Integer.MIN_VALUE;
		return res.data;
	}

	public static int kthSmallest2(BSTNode root, int k) {
		while (root != null) {
			if (root.lrank == k)
				break;
			if (k < root.lrank)
				root = root.left;
			else {
				root = root.right;
				k = k - root.lrank;
			}
		}
		if (root == null)
			return Integer.MIN_VALUE;
		return root.data;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package com.alg.top20.bbst;

public class Selection {

	public static int selection1(BSTNode root, int k) {
		MyInteger count = new MyInteger(0);
		BSTNode res = auxInOrder(root, k, count);
		if (res != null)
			return res.data;
		return Integer.MIN_VALUE;
	}

	private static BSTNode auxInOrder(BSTNode root, int k, MyInteger count) {
		if (root == null)
			return null;
		BSTNode left = auxInOrder(root.left, k, count);
		if (left != null)
			return left;
		if (count.get() + 1 == k)
			return root;
		count.set(count.get() + 1);
		return auxInOrder(root.right, k, count);
	}

	public static int selection2(BSTNode root, int k) {
		int count = 0;
		while (root != null) {
			if (root.left == null) {
				if (++count == k)
					return root.data;
				root = root.right;			
			} else {
				BSTNode tmp = root.left;
				while (tmp.right != null && tmp.right != root)
					tmp = tmp.right;
				if (tmp.right == null) {
					tmp.right = root;
					root = root.left;
				} else {
					if (++count == k)
						return root.data;
					tmp.right = null;
					root = root.right;
				}
			} // end of outer else
		}// end of while
		return Integer.MIN_VALUE;
	}

	public static int selection3(BSTNode root, int k) {
		while (root != null) {
			if (k == root.lst_size + 1)
				return root.data;
			if (k < root.lst_size + 1)
				root = root.left;
			else {
				k = k - (root.lst_size + 1);
				root = root.right;				
			}
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BSTNode root = BSTUtils.generateBBST(n);
		BSTUtils.display(root);
		int k = Integer.parseInt(args[1]);
		System.out.println(selection1(root, k));
		System.out.println(selection2(root, k));
		System.out.println(selection3(root, k));
	}

}

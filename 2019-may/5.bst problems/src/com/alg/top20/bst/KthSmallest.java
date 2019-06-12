package com.alg.top20.bst;

public class KthSmallest {

	public static int kthSmallest1(BSTNode root, int k) {
		MyInteger count = new MyInteger(0);
		Integer res = auxkthSmallest1(root, k, count);
		if(res == null) return Integer.MIN_VALUE;
		return res;
	}
	public static Integer auxkthSmallest1(BSTNode root, int k, MyInteger count) {
		if (root == null) return null;
		Integer left =  auxkthSmallest1(root.left, k, count);
		if (left != null) return left;
		count.incr();
		if(count.get() == k) return root.data; 
		return auxkthSmallest1(root.right, k, count);
	}
	
	public static int kthSmallest2(BSTNode root, int k) {
		int res = Integer.MIN_VALUE;
		while (root != null) {
			if (k == root.lst_size+1)
				return root.data;
			if (k > root.lst_size+1) {
				k = k - (root.lst_size+1);
				root = root.right;
			} else
				root = root.left;
		}
		return res;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		BSTNode root = BSTUtils.createUniqueBST(n);
		BSTUtils.displayTree(root);
		System.out.println(kthSmallest1(root, k));
		System.out.println(kthSmallest2(root, k));
	}

}

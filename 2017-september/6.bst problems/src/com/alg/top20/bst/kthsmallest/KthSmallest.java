package com.alg.top20.bst.kthsmallest;

import com.alg.top20.bst.BSTUtils;
import com.alg.top20.bst.MyInteger;
import com.alg.top20.bst.TreeNode;

public class KthSmallest {
	// TC:O(n)
	// SC:O(h)
	public static int kthSmallest1(TreeNode root, int k) {
		MyInteger count = new MyInteger(0);
		TreeNode tmp = auxSmallest1(root, k, count);
		if (tmp != null)
			return tmp.data;
		return Integer.MIN_VALUE;
	}

	private static TreeNode auxSmallest1(TreeNode root, int k, MyInteger count) {
		if (root == null)
			return null;
		TreeNode tmp = auxSmallest1(root.left, k, count);
		if (tmp != null)
			return tmp;
		if (count.get() + 1 == k)
			return root;
		count.set(count.get() + 1);
		return auxSmallest1(root.right, k, count);
	}

	// TC:O(n)
	// SC:O(1)
	//TODO: update all the back links to null before return
	public static int kthSmallest2(TreeNode root, int k) {
		int count = 0;
		TreeNode current = root;
		while (current != null) {
			// if left child does not exist
			if (current.left == null) {
				++count;
				if (count == k)
					return current.data;
				current = current.right;
				continue;
			}
			// find the inorder predecessor of current
			TreeNode tmp = current.left;
			while (tmp.right != null && tmp.right != current)
				tmp = tmp.right;
			// is the node visited first time?
			if (tmp.right == null) {
				tmp.right = current;
				current = current.left;
			} else {
				++count;
				if (count == k)
					return current.data;
				tmp.right = null;
				current = current.right;
			}
		}
		return Integer.MIN_VALUE;
	}

	// TC:O(log n)
	// SC:O(1)
	public static int kthSmallest3(TreeNode root, int k) {
		while (root != null) {
			if (k == root.ls_size + 1)
				return root.data;
			if (k < root.ls_size + 1)
				root = root.left;
			else {
				k = k - (root.ls_size + 1);
				root = root.right;
			}
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		TreeNode root = BSTUtils.createBST(n);
		BSTUtils.display1(root);
		System.out.println(k);
		System.out.println(kthSmallest3(root, k));
	}

}

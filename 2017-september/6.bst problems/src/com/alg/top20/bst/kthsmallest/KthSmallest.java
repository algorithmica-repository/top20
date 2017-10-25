package com.alg.top20.bst.kthsmallest;

import com.alg.top20.bst.MyInteger;
import com.alg.top20.bst.TreeNode;

public class KthSmallest {
	//TC:O(n)
	//SC:O(h)
	public static int kthSmallest1(TreeNode root, int k) {
		MyInteger count = new MyInteger(0);
		auxSmallest1(root, k, count);
		return 0;
	}
	private static TreeNode auxSmallest1(TreeNode root, int k, MyInteger count) {
		auxSmallest1(root.left, k, count);
		if(count.get()+1 == k) return root;
		count.set(count.get()+1);
		auxSmallest1(root.right, k, count);
		return null;
	}
	//TC:O(n)
	//SC:O(1)
	public static int kthSmallest2(TreeNode root) {
		return 0;
	}
	//TC:O(log  n)
	//SC:O(1)
	public static int kthSmallest3(TreeNode root) {
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

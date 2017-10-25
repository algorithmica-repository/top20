package com.alg.top20.bst.bstmin;

import com.alg.top20.bst.BSTUtils;
import com.alg.top20.bst.TreeNode;

public class BSTMin {

	//TC:O(h)
	//SC:O(1)
	public static Integer findMin(TreeNode root) {
		if(root == null) return null;
		while(root.left != null)
			root = root.left;
		return root.data;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BSTUtils.createBBST(n);
		BSTUtils.display1(root);
		System.out.println(findMin(root));
	}

}

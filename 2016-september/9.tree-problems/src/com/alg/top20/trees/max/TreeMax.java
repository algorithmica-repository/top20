package com.alg.top20.trees.max;

import java.util.LinkedList;
import java.util.Queue;

import com.alg.top20.trees.size.TreeNode;

public class TreeMax {

	public static int treeMax1(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		if (root.left == null && root.right == null)
			return root.data;
		int lmax = treeMax1(root.left);
		int rmax = treeMax1(root.right);
		return Math.max(Math.max(lmax, rmax), root.data);
	}

	public static int treeMax2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int max = Integer.MIN_VALUE;

		while (!queue.isEmpty()) {
			TreeNode tmp = queue.remove();
			if(tmp.data  > max)
				max = tmp.data;
			if (tmp.left != null)
				queue.add(tmp.left);
			if (tmp.right != null)
				queue.add(tmp.right);
		}
		return max;
	}
	
}

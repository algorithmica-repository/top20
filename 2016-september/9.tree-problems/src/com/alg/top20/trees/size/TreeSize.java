package com.alg.top20.trees.size;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSize {

	public static int treeSize1(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int ls = treeSize1(root.left);
		int rs = treeSize1(root.right);
		return ls + rs + 1;
	}

	public static int treeSize2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int size = 0;

		while (!queue.isEmpty()) {
			TreeNode tmp = queue.remove();
			++size;
			if (tmp.left != null)
				queue.add(tmp.left);
			if (tmp.right != null)
				queue.add(tmp.right);
		}
		return size;
	}
	
}

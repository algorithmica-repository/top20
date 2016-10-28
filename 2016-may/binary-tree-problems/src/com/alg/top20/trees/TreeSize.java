package com.alg.top20.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSize {

	public static int treeSize1(TreeNode current) {
		if (current == null)
			return 0;
		if (current.left == null && current.right == null)
			return 1;
		int ls = treeSize1(current.left);
		int rs = treeSize1(current.right);
		return ls + rs + 1;
	}

	public static int treeSize2(TreeNode current) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(current);
		int size = 0;
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			++size;
			if (tmp.left != null)
				q.add(tmp.left);
			if (tmp.right != null)
				q.add(tmp.right);
		}
		return size;
	}
	
	public static int treeSize3(TreeNode current) {
		return 0;
	}

}

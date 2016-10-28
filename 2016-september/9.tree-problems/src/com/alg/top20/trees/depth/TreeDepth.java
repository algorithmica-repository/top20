package com.alg.top20.trees.depth;

import java.util.LinkedList;
import java.util.Queue;

import com.alg.top20.trees.size.TreeNode;

public class TreeDepth {

	
	public static int treeDepth1(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int ld = treeDepth1(root.left);
		int rd = treeDepth1(root.right);
		return Math.max(ld, rd) + 1;
	}

	public static int treeDepth2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		int levels = 0;

		while (true) {
			TreeNode tmp = queue.remove();
			if(tmp == null) {
				++levels;
				if(queue.isEmpty()) break;
				queue.add(null);
				continue;
			} 
			if (tmp.left != null)
				queue.add(tmp.left);
			if (tmp.right != null)
				queue.add(tmp.right);
		}
		return levels;
	}
	
}

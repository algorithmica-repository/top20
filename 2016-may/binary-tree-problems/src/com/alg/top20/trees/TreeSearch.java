package com.alg.top20.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSearch {
	
	public static boolean treeSearch1(TreeNode current, Integer x) {
		if (current == null)
			return false;
		if(x.equals(current.data)) return true;
		boolean ret = treeSearch1(current.left, x);
		if(ret) return true;
		return treeSearch1(current.right, x);
	}

	public static boolean treeSearch2(TreeNode current, Integer x) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(current);
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			if(x.equals(tmp.data)) return true;
			if (tmp.left != null)
				q.add(tmp.left);
			if (tmp.right != null)
				q.add(tmp.right);
		}
		return false;
	}
	

}

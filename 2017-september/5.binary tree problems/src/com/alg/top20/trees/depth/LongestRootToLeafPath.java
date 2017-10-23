package com.alg.top20.trees.depth;

import java.util.LinkedList;
import java.util.Queue;

import com.alg.top20.trees.BinaryTreeUtils;
import com.alg.top20.trees.MyInteger;
import com.alg.top20.trees.TreeNode;

public class LongestRootToLeafPath {
	//TC:O(n)
	//SC:O(n)
	public static int findLongestRootToLeafPath1(TreeNode root) {
		MyInteger maxDepth = new MyInteger(Integer.MIN_VALUE);
		auxPath1(root, 0, maxDepth);
		return maxDepth.get();
	}
	private static void auxPath1(TreeNode root, int depth, MyInteger maxDepth) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			maxDepth.set(Math.max(maxDepth.get(), depth + 1));
			return;
		}
		auxPath1(root.left, depth + 1, maxDepth);
		auxPath1(root.right, depth + 1, maxDepth);
	}
	
	//TC:O(n)
	//SC:O(n)
	public static int findLongestRootToLeafPath2(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int left = findLongestRootToLeafPath2(root.left);
		int right = findLongestRootToLeafPath2(root.right);
		return Math.max(left, right) + 1;
	}
	
	//TC:O(n)
	//SC:O(n)
	public static int findLongestRootToLeafPath3(TreeNode root) {
		int nlevels = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			TreeNode current = q.remove();
			if(current == null) {
				++nlevels;
				if(! q.isEmpty())
					q.add(null);
				continue;
			}
			if (current.left != null)
				q.add(current.left);
			if (current.right != null)
				q.add(current.right);
		}
		return nlevels;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createTree(n);
		BinaryTreeUtils.display1(root);
		System.out.println(findLongestRootToLeafPath1(root));
		System.out.println(findLongestRootToLeafPath2(root));
		System.out.println(findLongestRootToLeafPath3(root));
	}

}

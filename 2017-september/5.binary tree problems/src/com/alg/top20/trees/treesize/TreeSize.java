package com.alg.top20.trees.treesize;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.alg.top20.trees.BinaryTreeUtils;
import com.alg.top20.trees.TreeNode;

public class TreeSize {

	// TC:O(n)
	// SC:O(n)
	public static int treeSize1(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int ls = treeSize1(root.left);
		int rs = treeSize1(root.right);
		return ls + rs + 1;
	}

	// TC:O(n)
	// SC:O(n)
	public static int treeSiz2(TreeNode root) {
		int size = 0;
		Stack<TreeNode> st = new Stack<TreeNode>();

		while (true) {
			while (root != null) {
				++size;
				st.push(root);
				root = root.left;
			}
			if (st.isEmpty())
				break;
			root = st.pop().right;
		}
		return size;
	}

	// TC:O(n)
	// SC:O(n)
	public static int treeSize3(TreeNode root) {
		int size = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode current = q.remove();
			++size;
			if (current.left != null)
				q.add(current.left);
			if (current.right != null)
				q.add(current.right);
		}
		return size;
	}

	// TC:O(n)
	// SC:O(1)
	public static int treeSize4(TreeNode root) {
		int size = 0;
		TreeNode current = root;
		while (current != null) {
			//if left child does not exist
			if (current.left == null) {
				++size;
				current = current.right;
				continue;
			}
			//find the inorder predecessor of current
			TreeNode tmp = current.left;
			while (tmp.right != null && tmp.right != current)
				tmp = tmp.right;
			//is the node visited first time?
			if (tmp.right == null) {
				++size;
				tmp.right = current;
				current = current.left;
			} else {
				tmp.right = null;
				current = current.right;
			}
		}

		return size;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createTree(n);
		BinaryTreeUtils.display1(root);
		System.out.println(treeSize1(root));
		System.out.println(treeSiz2(root));
		System.out.println(treeSize4(root));
	}

}

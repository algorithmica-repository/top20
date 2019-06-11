package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSearch {

	public static boolean treeSearch1(BTNode root, int x) {
		if (root == null) return false;
		if (root.data == x) return true;
		boolean left = treeSearch1(root.left, x);
		if(left == true) return true;
		return  treeSearch1(root.right, x);
	}

	public static boolean treeSearch2(BTNode root, int x) {
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		while (!q.isEmpty()) {
			BTNode tmp = q.remove();
			if(tmp.data == x) return true;
			if (tmp.left != null)
				q.add(tmp.left);
			if (tmp.right != null)
				q.add(tmp.right);
		}
		return false;
	}
	private static BTNode inorder_predecessor(BTNode p) {
		BTNode current = p;
		p = p.left;
		while(p.right != null && p.right != current)
			p = p.right;
		return p;
	}
	public static boolean treeSearch3(BTNode root, int x) {
		while (root != null) {
			//Is Left subtree exist?
			if (root.left != null) {
				BTNode tmp = inorder_predecessor(root);
				//should we visit left or right subtree?
				if (tmp.right == null) {
					if(root.data == x) return true;
					tmp.right = root;
					root = root.left;
				} else {
					tmp.right = null;
					root = root.right;
				}
			} else {
				if(root.data == x) return true;
				root = root.right;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BTNode root = BinaryTreeUtils.createUniqueBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		System.out.println(treeSearch1(root, 10));
		System.out.println(treeSearch2(root, 10));
		System.out.println(treeSearch3(root, 10));

	}


}

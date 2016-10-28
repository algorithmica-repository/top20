package com.alg.top20.balbst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TestBBST {
	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public int height(TreeNode current) {
		return current != null ? current.height : 0;
	}

	private TreeNode rotateLeft(TreeNode current) {
		return null;
	}

	private TreeNode rotateRight(TreeNode current) {
		return null;
	}

	private TreeNode rotateRightLeft(TreeNode current) {
		return null;
	}

	private TreeNode rotateLeftRight(TreeNode current) {
		return null;
	}

	private TreeNode auxAdd(TreeNode current, Integer key) {
		if (current == null) {
			return new TreeNode(key);
		}
		int ret = key.compareTo(current.data);
		if (ret < 0) {
			current.left = auxAdd(current.left, key);
			if (Math.abs(height(current.left) - height(current.right)) > 1) {
				int tmp = key.compareTo(current.left.data);
				if (tmp < 0) {
					return rotateRight(current);
				} else {
					return rotateLeftRight(current);
				}
			}
		} else {
			current.right = auxAdd(current.right, key);
			if (Math.abs(height(current.left) - height(current.right)) > 1) {
				int tmp = key.compareTo(current.right.data);
				if (tmp > 0) {
					return rotateLeft(current);
				} else {
					return rotateRightLeft(current);
				}
			}
		}
		return current;
	}

	public void add(Integer key) {
		TreeNode tmp = auxAdd(root, key);
		if (root == null)
			root = tmp;
	}

	public void display() {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		System.out.println(root.data);
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			if (tmp.left != null) {
				q.add(tmp.left);
				System.out.println(tmp.left.data);
			} else {
				System.out.println("null");
			}
			if (tmp.right != null) {
				q.add(tmp.right);
				System.out.println(tmp.right.data);
			} else {
				System.out.println("null");
			}
		}
	}

	public void randomBBST(int n) {
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			add(r.nextInt(100) + 1);
			// display();
		}
	}

	private static TreeNode auxBBST(int[] in, int l, int r) {
		if (l > r)
			return null;
		if (l == r)
			return new TreeNode(in[l]);
		int m = (l + r) / 2;
		TreeNode tmp = new TreeNode(in[m]);
		tmp.left = auxBBST(in, l, m - 1);
		tmp.right = auxBBST(in, m + 1, r);
		return tmp;
	}

	public static TreeNode buildBBST(int[] in) {
		return auxBBST(in, 0, in.length - 1);
	}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		TestBBST bbst = new TestBBST();
		bbst.randomBBST(size);
		bbst.display();
	}

}

package com.alg.top20.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinarySearchTree {
	
	private TreeNode root;

	class TreeNode {
		Integer data;
		TreeNode left;
		TreeNode right;

		TreeNode(Integer key) {
			data = key;
		}
	}

	public void add(Integer key) {
		TreeNode current = root;
		if (current == null)
			root = new TreeNode(key);
		else {
			int res = 0;
			TreeNode parent = null;
			while (current != null) {
				res = key.compareTo(current.data);
				parent = current;
				if (res < 0) {
					current = current.left;
				} else {
					current = current.right;
				}
			}
			if(res  < 0) parent.left = new TreeNode(key);
			else parent.right = new TreeNode(key);

		}
	}

	public void generateBT(int n) {
		Random r = new Random(100);
		for (int i = 0; i < n; ++i) {
			add(r.nextInt(1000) + 1);
		}
	}

	public void display() {
		TreeNode current = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(current);
		q.add(null);
		while (!q.isEmpty()) {
			current = q.remove();
			if(current!=null) System.out.print(current.data + " ");
			if (current == null) {
				System.out.println();
				if (!q.isEmpty())
					q.add(null);
				continue;
			}
			if (current.left != null)
				q.add(current.left);
			if (current.right != null)
				q.add(current.right);
		}

	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.generateBT(10);
		tree.display();
	}
}

package com.alg.top20.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TestBinaryTree {
	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void add(Integer key) {
		TreeNode current = root;
		if (current == null) {
			root = new TreeNode(key);
			return;
		}
		while (true) {
			if (Math.random() <= 0.5) {
				if (current.left == null) {
					current.left = new TreeNode(key);
					break;
				} else
					current = current.left;
			} else {
				if (current.right == null) {
					current.right = new TreeNode(key);
					break;
				} else
					current = current.right;
			}
		}
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

	public void randomBT(int n) {
		Random r = new Random(100);
		for (int i = 0; i < n; ++i) {
			add(r.nextInt(100) + 1);
		}
	}

	public static void testTailRecursion() {
		int n = 120;
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			in[i] = r.nextInt(100) + 1;
		}
		Arrays.sort(in);

		int x = r.nextInt(100) + 1;
		System.out.println(Arrays.toString(in));
		System.out.println(x);
		System.out.println(RecNonRecTranf.bsearchR(in, 0, in.length, x));
		System.out.println(RecNonRecTranf.bsearchNR(in, 0, in.length, x));
	}
	public static void main(String[] args) {
		/*int size = Integer.parseInt(args[0]);
		TestBinaryTree bt = new TestBinaryTree();
		bt.randomBT(size);
		bt.display();
		System.out.println();
		RecNonRecTranf.postOrderR(bt.getRoot());
		System.out.println();
		RecNonRecTranf.postOrderNR(bt.getRoot());*/
		testTailRecursion();
	}

}

package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinaryTreeUtils {

	private static BTNode add1(BTNode root, int data) {
		if (root == null)
			return new BTNode(data);
		BTNode current = root, parent = null;
		Random r = new Random();
		while (current != null) {
			parent = current;
			if (r.nextInt(2) == 0) {
				if (current.left == null) {
					parent.left = new BTNode(data);
					break;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					parent.right = new BTNode(data);
					break;
				}
				current = current.right;
			}
		}
		return root;
	}
	
	private static BTNode add2(BTNode root, int data) {
		if (root == null)
			return new BTNode(data);
		BTNode current = root, parent = null;
		Random r = new Random();
		while (current != null) {
			parent = current;
			if (r.nextInt(2) == 0) {
				if (current.left == null) {
					parent.left = new BTNode(data);
					break;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					parent.right = new BTNode(data);
					break;
				}
				current = current.right;
			}
		}
		return root;
	}


	//it is generating biased binary trees not the random binary tree
	public static BTNode createBinaryTree(int n) {
		Random r = new Random();
		BTNode root = null;
		for (int i = 0; i < n; ++i) {
			int data = r.nextInt(n) + 1;
			root = add1(root, data);
		}
		return root;
	}
	
	public static BTNode createUniqueBinaryTree(int n) {
		BTNode root = null;
		for (int i = 0; i < n; ++i) 
			root = add1(root, i+1);
		return root;
	}

	public static BTNode createOneSidedBinaryTree(int n) {
		Random r = new Random();
		BTNode root = null;
		for (int i = 0; i < n; ++i) {
			int data = r.nextInt(n) + 1;
			BTNode tmp = new BTNode(data);
			if (root != null) {
				tmp.left = root;
			} 
			root = tmp;
		}
		return root;
	}

	
	public static void displayTree(BTNode root) {
		auxDisplay(root, 0, "Root");
	}

	private static void auxDisplay(BTNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.data + "(" + type + ")");
		auxDisplay(root.left, nspaces + 4, "L");
		auxDisplay(root.right, nspaces + 4, "R");
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BTNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);

	}
}

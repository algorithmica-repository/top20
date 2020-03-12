package com.alg.top20.bt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerDe {

	public static String ser1(TreeNode root) {
		if (root == null)
			return "#";
		String left = ser1(root.left);
		String right = ser1(root.right);
		return root.data + "," + left + "," + right;
	}

	public static TreeNode deser11(String in) {
		String[] tokens = in.split(",");
		MyInteger index = new MyInteger(0);
		return auxdeser11(tokens, index);
	}

	private static TreeNode auxdeser11(String[] tokens, MyInteger index) {
		if (tokens[index.get()].equals("#"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(tokens[index.get()]));
		index.incr();
		root.left = auxdeser11(tokens, index);
		index.incr();
		root.right = auxdeser11(tokens, index);
		return root;
	}

	public static TreeNode deser12(String in) {
		String[] tokens = in.split(",");
		Queue<String> q = new LinkedList<String>();
		for (String token : tokens)
			q.add(token);
		return auxdeser12(q);
	}

	private static TreeNode auxdeser12(Queue<String> q) {
		String token = q.remove();
		if (token.equals("#"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(token));
		root.left = auxdeser12(q);
		root.right = auxdeser12(q);
		return root;
	}

	private static String preOrder(TreeNode root) {
		if (root == null)
			return "";
		String left = preOrder(root.left);
		String right = preOrder(root.right);
		return root.data + "," + left + "," + right;
	}

	private static String inOrder(TreeNode root) {
		if (root == null)
			return "";
		String left = inOrder(root.left);
		String right = inOrder(root.right);
		return left + "," + root.data + "," + right;
	}

	public static String ser3(TreeNode root) {
		String res = preOrder(root);
		res = res + "#";
		res = res + inOrder(root);
		return res;
	}

	public static TreeNode deser3(String input) {
		String[] tokens = input.split("#");
		String[] pre = tokens[0].split(",");
		String[] in = tokens[1].split(",");
		Queue<Integer> preq = new LinkedList<Integer>();
		for (String token : pre) {
			if (token.trim().length() != 0)
				preq.add(Integer.parseInt(token));
		}
		int i = 0;
		int[] inorder = new int[preq.size()];
		for (String token : in) {
			if (token.trim().length() != 0)
				inorder[i++] = Integer.parseInt(token);
		}
		System.out.println(preq);
		System.out.println(Arrays.toString(inorder));		
		return auxdeser3(preq, inorder, 0, inorder.length-1);

	}
	private static int findElementIndex(Integer current, int[] in, int l, int r) {
		for(int i = l; i <= r; ++i)
			if(in[i] == current) return i;
		return -1;
	}
	private static TreeNode auxdeser3(Queue<Integer> pre, int[] in, int l, int r) {
		if(l > r) return null;
		Integer current = pre.remove();
		int p = findElementIndex(current, in, l, r);
		TreeNode root = new TreeNode(current);
		root.left = auxdeser3(pre, in, l, p-1);
		root.right = auxdeser3(pre, in, p+1, r);
		return root;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		String res = ser3(root);
		System.out.println(res);
		root = deser3(res);
		BinaryTreeUtils.displayTree(root);
	}

}

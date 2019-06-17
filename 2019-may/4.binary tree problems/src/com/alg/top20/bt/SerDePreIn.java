package com.alg.top20.bt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerDePreIn {

	public static void preorder(BTNode root, int[] pre, MyInteger index) {
		if(root == null) return;
		pre[index.get()] = root.data;
		index.incr();
		preorder(root.left, pre, index);
		preorder(root.right, pre, index);
	}
	public static void inorder(BTNode root, int[] in, MyInteger index) {
		if(root == null) return;
		inorder(root.left, in, index);
		in[index.get()] = root.data;
		index.incr();
		inorder(root.right, in, index);
	}
	public static void serialize(BTNode root, int[] pre, int[] in) {
		MyInteger index = new MyInteger(0);
		preorder(root, pre, index);
		index = new MyInteger(0);
		inorder(root, in, index);
	}
	public static BTNode deserialize(int[] in, int[] pre) {
		MyInteger index = new MyInteger(0);
		return auxDeserialize(in, pre, 0, in.length-1, index);
	}
	private static int findPosition(int[] in, int x) {
		for(int i = 0; i < in.length; ++i)
			if(in[i] == x) return i;
		return -1;
	}
	private static BTNode auxDeserialize(int[] in, int[] pre, int l, int r, MyInteger index) {
		if(l > r) return null;
		BTNode root = new BTNode(pre[index.get()]);
		int p = findPosition(in, pre[index.get()]);
		index.incr();
		root.left = auxDeserialize(in, pre, l, p-1, index);
		root.right = auxDeserialize(in, pre, p+1, r, index);
		return root;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BTNode root = BinaryTreeUtils.createUniqueBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
			
		int[] in = new int[n];
		int[] pre = new int[n];
		serialize(root, pre, in);
		System.out.println(Arrays.toString(in));
		System.out.println(Arrays.toString(pre));
		
		root = deserialize(in, pre);
		BinaryTreeUtils.displayTree(root);

	}

}

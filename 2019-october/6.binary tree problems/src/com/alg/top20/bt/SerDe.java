package com.alg.top20.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerDe {

	public static Queue<Integer> ser1(TreeNode root) {
		Queue<Integer> list = new LinkedList<Integer>();
		auxSer1(root, list);
		return list;
	}

	private static void auxSer1(TreeNode root, Queue<Integer> list) {
		if (root == null) {
			list.add(-1);
			return;
		}
		list.add(root.data);
		auxSer1(root.left, list);
		auxSer1(root.right, list);
	}

	public static TreeNode deser1(Queue<Integer> in) {
		int tmp = in.remove();
		if (tmp == -1)
			return null;
		TreeNode root = new TreeNode(tmp);
		root.left = deser1(in);
		root.right = deser1(in);
		return root;           
	}

	public static void ser3(TreeNode root, List<Integer> pre, List<Integer> in) {
		if (root == null)
			return;
		pre.add(root.data);
		ser3(root.left, pre, in);
		in.add(root.data);
		ser3(root.right, pre, in);
	}

	private static int findPosition(int x, List<Integer> list, int l, int r) {
		while (l <= r) {
			if (list.get(l) == x)
				break;
			++l;
		}
		return l;
	}

	public static TreeNode deser3(List<Integer> pre, List<Integer> in) {
		return auxdeser3(pre, in, 0, pre.size() - 1);
	}

	private static TreeNode auxdeser3(List<Integer> pre, List<Integer> in, int left, int right) {
		if (left > right)
			return null;
		int tmp = pre.remove(0);
		TreeNode root = new TreeNode(tmp);
		int pos = findPosition(tmp, in, left, right);
		root.left = auxdeser3(pre, in, left, pos - 1);
		root.right = auxdeser3(pre, in, pos + 1, right);
		return root;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createUniqueBinaryTree(n);
		BinaryTreeUtils.displayTree(root);

		List<Integer> pre = new ArrayList<Integer>();
		List<Integer> in = new ArrayList<Integer>();
		ser3(root, pre, in);
		System.out.println(pre);
		System.out.println(in);
		root = deser3(pre, in);
		BinaryTreeUtils.displayTree(root);
	}

}

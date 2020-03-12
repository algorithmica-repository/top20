package com.alg.top20.bst;

import java.util.ArrayList;
import java.util.List;

public class SerDe {

	public static List<Integer> serialize(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		auxSerialize(root, list);
		return list;
	}

	private static void auxSerialize(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		list.add(root.data);
		auxSerialize(root.left, list);
		auxSerialize(root.right, list);
	}

	public static TreeNode deserialize(List<Integer> list) {
		TreeNode root = null;
		for (Integer x : list)
			root = BSTUtils.add(root, x);
		return root;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BSTUtils.createUniqueBST(n);
		BSTUtils.displayTree(root);
		List<Integer> list = serialize(root);
		System.out.println(list);
		root = deserialize(list);
		BSTUtils.displayTree(root);
	}

}

package com.alg.top20.bt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec3 {

	private void auxPreorder(TreeNode root, StringBuilder sb) {
		if(root == null) return;
		sb.append(root.data+",");
		auxPreorder(root.left, sb);
		auxPreorder(root.right, sb);
	}	
	private void auxInorder(TreeNode root, StringBuilder sb) {
		if(root == null) return;
		auxInorder(root.left, sb);
		sb.append(root.data+",");
		auxInorder(root.right, sb);
	}
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		auxPreorder(root, sb);
		sb.append("#,");
		auxInorder(root, sb);
		return sb.toString();
	}
	
	public TreeNode deserialize(String input) {
		String[] tokens = input.split("#,");
		List<String> pre = new LinkedList<String>(Arrays.asList(tokens[0].split(",")));
		List<String> in = new LinkedList<String>(Arrays.asList(tokens[1].split(",")));
		System.out.println(pre);
		System.out.println(in);
		return auxDeserialize(pre, in, 0, pre.size()-1);
	}
	private int findPosition(List<String> in, int l, int r, String val) {
		int i;
		for(i = l; i <= r; ++i)
			if(in.get(i).equals(val)) break;
		return i;
	}
	private TreeNode auxDeserialize(List<String> pre, List<String> in, int l, int r) {
		if(l > r) return null;
		String val = pre.remove(0);
		TreeNode tmp = new TreeNode(Integer.parseInt(val));
		int p = findPosition(in, l, r, val);
		tmp.left = auxDeserialize(pre, in, l, p-1);
		tmp.right = auxDeserialize(pre, in, p+1, r);
		return tmp;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		Codec3 cd3 = new Codec3();
		String in = cd3.serialize(root);
		System.out.println(in);
		root = cd3.deserialize(in);
		BinaryTreeUtils.displayTree2(root);
	}

}

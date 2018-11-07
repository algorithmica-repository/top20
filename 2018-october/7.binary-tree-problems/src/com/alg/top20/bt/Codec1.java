package com.alg.top20.bt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec1 {

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		auxSerialize(root, sb);
		return sb.toString();
	}
	private void auxSerialize(TreeNode root, StringBuilder sb) {
		if(root == null) {
			sb.append("#,");
			return;
		}
		sb.append(root.data+",");
		auxSerialize(root.left, sb);
		auxSerialize(root.right, sb);
	}
	public TreeNode deserialize(String in) {
		String[] tokens = in.split(",");
		List<String> list = new LinkedList<String>(Arrays.asList(tokens));
		return auxDeserialize(list);
	}
	private TreeNode auxDeserialize(List<String> in) {
		String val = in.remove(0);
		if(val.equals("#")) return null;
		TreeNode tmp = new TreeNode(Integer.parseInt(val));
		tmp.left = auxDeserialize(in);
		tmp.right = auxDeserialize(in);
		return tmp;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		Codec1 cd1 = new Codec1();
		String in = cd1.serialize(root);
		System.out.println(in);
		root = cd1.deserialize(in);
		BinaryTreeUtils.displayTree2(root);
	}

}

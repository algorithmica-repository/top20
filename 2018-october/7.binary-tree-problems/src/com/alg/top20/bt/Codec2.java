package com.alg.top20.bt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec2 {

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			if(tmp == null)
				sb.append("#,");
			else {
				sb.append(tmp.data+",");
				q.add(tmp.left);
				q.add(tmp.right);
			}
		}
		return sb.toString();
	}
	
	public TreeNode deserialize(String in) {
		String[] tokens = in.split(",");
		List<String> list = new LinkedList<String>(Arrays.asList(tokens));
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(list.remove(0)));
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			String left = list.remove(0);
			if(left.equals("#"))
				tmp.left = null;
			else {
				tmp.left = new TreeNode(Integer.parseInt(left));
				q.add(tmp.left);
			}
			String right = list.remove(0);
			if(right.equals("#"))
				tmp.right = null;
			else {
				tmp.right = new TreeNode(Integer.parseInt(right));
				q.add(tmp.right);
			}
		}
		return root;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		Codec2 cd2 = new Codec2();
		String in = cd2.serialize(root);
		System.out.println(in);
		root = cd2.deserialize(in);
		BinaryTreeUtils.displayTree2(root);
	}

}

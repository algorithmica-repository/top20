package com.alg.top20.bt.codec;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.alg.top20.bt.BinaryTreeUtils;
import com.alg.top20.bt.TreeNode;

public class Codec2 {

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			if (tmp == null)
				sb.append("#").append(",");
			else {
				sb.append(tmp.data).append(",");
				q.add(tmp.left);
				q.add(tmp.right);
			}
		}
		return sb.toString();
	}

	public TreeNode deSerialize(String s) {
		Queue<String> tokens = new LinkedList<String>();
		Collections.addAll(tokens, s.split(","));
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(tokens.remove()));
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			String ltoken = tokens.remove();
			if (ltoken.equals("#"))
				tmp.left = null;
			else {
				tmp.left = new TreeNode(Integer.parseInt(ltoken));
				q.add(tmp.left);
			}
			String rtoken = tokens.remove();
			if (rtoken.equals("#"))
				tmp.right = null;
			else {
				tmp.right = new TreeNode(Integer.parseInt(rtoken));
				q.add(tmp.right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		Codec2 c = new Codec2();
		String enc = c.serialize(root);
		System.out.println(enc);
		TreeNode root1 = c.deSerialize(enc);
		BinaryTreeUtils.displayTree2(root1);
	}

}

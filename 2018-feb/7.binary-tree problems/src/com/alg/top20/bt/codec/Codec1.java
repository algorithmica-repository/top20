package com.alg.top20.bt.codec;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.alg.top20.bt.BinaryTreeUtils;
import com.alg.top20.bt.TreeNode;

public class Codec1 {

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		auxSerialize(root, sb);
		return sb.toString();
	}
	private void auxSerialize(TreeNode root, StringBuilder sb) {
		if(root == null) {
			sb.append("#").append(",");
			return;
		}
		sb.append(root.data).append(",");
		auxSerialize(root.left, sb);
		auxSerialize(root.right, sb);
	}
	
	public TreeNode deSerialize(String s) {
		Queue<String> q = new LinkedList<String>();
		Collections.addAll(q, s.split(","));
		System.out.println(q);
		return auxDeSerialize(q);
	}
	private TreeNode auxDeSerialize(Queue<String> q) {
		String tmp = q.remove();
		if(tmp.equals("#")) return null;
		else {
			TreeNode root = new TreeNode(Integer.parseInt(tmp));
			root.left = auxDeSerialize(q);
			root.right = auxDeSerialize(q);
			return root;
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		Codec1 c = new Codec1();
		String enc = c.serialize(root);
		System.out.println(enc);
		TreeNode root1 = c.deSerialize(enc);
		BinaryTreeUtils.displayTree2(root1);
	}

}

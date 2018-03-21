package com.alg.top20.bt.codec;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alg.top20.bt.BinaryTreeUtils;
import com.alg.top20.bt.TreeNode;

public class Codec3 {

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		preOrder(root, sb);
		sb.deleteCharAt(sb.length()-1);
		sb.append("#");
		inOrder(root, sb);
		return sb.toString();
	}
	private void preOrder(TreeNode root, StringBuilder sb) {
		if(root == null) return;
		sb.append(root.data).append(",");
		preOrder(root.left, sb);
		preOrder(root.right, sb);
	}
	private void inOrder(TreeNode root, StringBuilder sb) {
		if(root == null) return;
		inOrder(root.left, sb);
		sb.append(root.data).append(",");
		inOrder(root.right, sb);
	}
	
	public TreeNode deSerialize(String s) {
		List<String> in = new LinkedList<String>();
		List<String> pre = new LinkedList<String>();
		String[] in_pre = s.split("#");
		Collections.addAll(pre, in_pre[0].split(","));
		Collections.addAll(in, in_pre[1].split(","));
		System.out.println(pre);
		System.out.println(in);
		return auxDeSerialize(pre, in, 0, in.size()-1);
	}
	private TreeNode auxDeSerialize(List<String> pre, List<String> in, int l, int r) {
		if(l > r) return null;
		String tmp = pre.remove(0);
		//System.out.println(tmp);
		TreeNode root = new TreeNode(Integer.parseInt(tmp));
		if(l == r) return root;
		int i;
		for(i = 0; i < in.size(); ++i) {
			if(tmp.equals(in.get(i)))
				break;
		}
		root.left = auxDeSerialize(pre, in, l, i-1);
		root.right = auxDeSerialize(pre, in, i+1, r);
		return root;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree1(n);
		BinaryTreeUtils.displayTree2(root);
		Codec3 c = new Codec3();
		String enc = c.serialize(root);
		System.out.println(enc);
		TreeNode root1 = c.deSerialize(enc);
		BinaryTreeUtils.displayTree2(root1);
	}

}

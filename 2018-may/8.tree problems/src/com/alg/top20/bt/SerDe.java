package com.alg.top20.bt;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SerDe {

	public static String serialize1(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		auxSerialize1(root, sb);
		return sb.toString();
	}
	private static void auxSerialize1(TreeNode root, StringBuilder sb) {
		if(root == null) {
			sb.append("#,");
			return;		
		}
		sb.append(root.data+",");
		auxSerialize1(root.left, sb);
		auxSerialize1(root.right, sb);
	}
	
	public static TreeNode deSerialize1(String data) {
		Queue<String> q = new LinkedList<String>();
		String[] tokens = data.split(",");
		Collections.addAll(q, tokens);
		System.out.println(q);
		return auxDeSerialize1(q);
	}
	private static TreeNode auxDeSerialize1(Queue<String> q) {
		String token = q.remove();
		if(token.equals("#")) return null;
		TreeNode root = new TreeNode(Integer.parseInt(token));
		root.left = auxDeSerialize1(q);
		root.right = auxDeSerialize1(q);
		return root;		
	}
	
	public static String serialize2(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode tmp = queue.remove();
			if(tmp == null) {
				sb.append("#,");
				continue;
			}
			else {
				sb.append(tmp.data + ",");
				queue.add(tmp.left);
				queue.add(tmp.right);
			}
		}
		return sb.toString();
	}
	
	public static TreeNode deSerialize2(String data) {
		Queue<String> q = new LinkedList<String>();
		String[] tokens = data.split(",");
		Collections.addAll(q, tokens);
		System.out.println(q);
		return auxDeSerialize2(q);
	}
	private static TreeNode auxDeSerialize2(Queue<String> data) {
		String seed = data.remove();
		TreeNode root = new TreeNode(Integer.parseInt(seed));
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode tmp = queue.remove();
			String ltoken = data.remove();
			if(ltoken.equals("#")) 
				tmp.left = null;
			else {
				tmp.left = new TreeNode(Integer.parseInt(ltoken));
				queue.add(tmp.left);
			}
			
			String rtoken = data.remove();
			if(rtoken.equals("#")) 
				tmp.right = null;
			else {
				tmp.right = new TreeNode(Integer.parseInt(rtoken));
				queue.add(tmp.right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		String data = serialize2(root);
		System.out.println(data);
		BinaryTreeUtils.displayTree2(deSerialize2(data));
	}

}

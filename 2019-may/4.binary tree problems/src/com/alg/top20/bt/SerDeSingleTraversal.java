package com.alg.top20.bt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerDeSingleTraversal {

	public static String serialize1(BTNode root) {
		StringBuilder sb = new StringBuilder();
		auxSerialize1(root, sb);
		return sb.toString();
	}
	private static void auxSerialize1(BTNode root, StringBuilder sb) {
		if(root == null) {
			sb.append("#,");
			return;
		}
		//gather root.data
		sb.append(root.data+",");
		auxSerialize1(root.left, sb);
		auxSerialize1(root.right, sb);
	}
	public static BTNode deserialize11(String s) {
		String[] tokens = s.split(",");
		//System.out.println(Arrays.toString(tokens));
		Queue<String> q = new LinkedList<String>();
		for(String token:tokens)
			q.add(token);
		return auxDeSerialize11(q);
	}
	private static BTNode auxDeSerialize11(Queue<String> q) {
		String current = q.remove();
		if(current.equals("#")) {
			return null;
		}
		BTNode root = new BTNode(Integer.parseInt(current));
		root.left = auxDeSerialize11(q);
		root.right = auxDeSerialize11(q);
		return root;
	}
	
	public static BTNode deserialize12(String s) {
		String[] tokens = s.split(",");
		MyInteger index = new MyInteger(0);
		return auxDeSerialize12(tokens, index);
	}
	private static BTNode auxDeSerialize12(String[] tokens, MyInteger index) {
		String current = tokens[index.get()];
		index.incr();
		if(current.equals("#")) {
			return null;
		}
		BTNode root = new BTNode(Integer.parseInt(current));
		root.left = auxDeSerialize12(tokens, index);
		root.right = auxDeSerialize12(tokens, index);
		return root;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BTNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		String tmp = serialize1(root);
		System.out.println(tmp);
		root = deserialize12(tmp);
		BinaryTreeUtils.displayTree(root);
	}

}

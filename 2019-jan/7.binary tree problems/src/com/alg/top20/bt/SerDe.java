package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class SerDe {

	public static String ser1(BTNode root) {
		StringBuilder sb = new StringBuilder();
		auxSer1(root, sb);
		return sb.toString();
	}
	private static void auxSer1(BTNode root, StringBuilder sb) {
		if(root == null) {
			sb.append("#,");
			return;
		}
		sb.append(root.data + ",");
		auxSer1(root.left, sb);
		auxSer1(root.right, sb);
	}
	
	public static BTNode deser1(String in) {
		String[] tokens = in.split(",");
		//System.out.println(Arrays.toString(tokens));
		Queue<String> q = new LinkedList<String>();
		for(String s: tokens)
			q.add(s);
		return auxDeser1(q);
	}
	private static BTNode auxDeser1(Queue<String> q) {
		String token = q.remove();
		if(token.equals("#")) return null;
		BTNode tmp = new BTNode(Integer.parseInt(token));
		tmp.left = auxDeser1(q);
		tmp.right = auxDeser1(q);
		return tmp;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BTNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		String tmp = ser1(root);
		System.out.println(tmp);
		root = deser1(tmp);
		BinaryTreeUtils.displayTree(root);
	}

}

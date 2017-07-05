package com.alg.top20.trees;

import java.util.*;

public class SerializeDeserializeBT1 {

	private static void inorder(TreeNode root, List<Integer> in) {
		if(root ==null) return;
		inorder(root.left, in);
		in.add(root.data);
		inorder(root.right, in);
	}
	private static void preorder(TreeNode root, List<Integer> pre) {
		if(root == null) return;
		pre.add(root.data);
		preorder(root.left, pre);
		preorder(root.right, pre);
	}
	public static void serialize1(TreeNode root, int[] pre, int[] in) {
		List<Integer> list = new ArrayList<Integer>();
		inorder(root, list);
		int i = 0;
		for(Integer e:list)
			in[i++] = e;
		list.clear();
		
		preorder(root, list);
		i = 0;
		for(Integer e:list)
			pre[i++] = e;
	}
	
	//TC:O(n^ 2)   SC:O(n)
	public static TreeNode deserialize1(int[] pre, int[] in) {
		return auxDeserialize1(pre, in, 0, 0, in.length-1);
	}	
	private static TreeNode	auxDeserialize1(int[] pre, int[] in, int pre_start, int in_start, int in_end) {
		if(in_start > in_end) return null;
		TreeNode tmp = new TreeNode(pre[pre_start]);
		int i;
		for(i = in_start; i <= in_end; ++i){
			if(in[i] == pre[pre_start])
				break;
		}
		tmp.left = auxDeserialize1(pre, in, pre_start+1, in_start, i-1);
		tmp.right = auxDeserialize1(pre, in,pre_start+(i-in_start)+1, i+1, in_end);
		return tmp;
	}
	
	//TC:O(n)   SC:O(n)
	public static TreeNode deserialize2(int[] pre, int[] in) {
		HashMap<Integer, Integer> in_map = new HashMap<Integer, Integer>();
		for(int i = 0; i <in.length; ++i){
			in_map.put(in[i], i);
		}
		MyInteger pre_start = new MyInteger();
		pre_start.set(0);
		return auxDeserialize2(pre, in, pre_start, 0, in.length-1, in_map);
	}
	
	private static TreeNode	auxDeserialize2(int[] pre, int[] in, MyInteger pre_start, int in_start, int in_end, HashMap<Integer, Integer> in_map) {
		if(in_start > in_end) return null;
		TreeNode tmp = new TreeNode(pre[pre_start.get()]);
		int i = in_map.get(pre[pre_start.get()]);
		pre_start.set(pre_start.get()+1);
		tmp.left = auxDeserialize2(pre, in,pre_start, in_start, i-1, in_map);
		tmp.right = auxDeserialize2(pre, in,pre_start, i+1, in_end,in_map);
		return tmp;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		int[] pre = new int[n];
		TreeNode root = BinaryTreeUtils.createBinaryTree2(n);
		BinaryTreeUtils.displayTree2(root);
		serialize1(root, pre, in);
		root = deserialize2(pre, in);
		BinaryTreeUtils.displayTree2(root);
	}
	
}

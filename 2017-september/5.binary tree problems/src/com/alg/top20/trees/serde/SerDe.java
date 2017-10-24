package com.alg.top20.trees.serde;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.alg.top20.trees.BinaryTreeUtils;
import com.alg.top20.trees.TreeNode;

public class SerDe {

	private static void preorder(TreeNode root, List<Integer> tmp) {
		if(root == null) return;
		tmp.add(root.data);
		preorder(root.left, tmp);
		preorder(root.right, tmp);
	}
	
	private static void inorder(TreeNode root, List<Integer> tmp) {
		if(root == null) return;
		inorder(root.left, tmp);
		tmp.add(root.data);
		inorder(root.right, tmp);
	}
	//TC:O(n)
	//SC:O(n) -> O(1)
	public static void serialize1(TreeNode root, int[] pre, int[] in) {
		 List<Integer> tmp = new LinkedList<Integer>();
		 preorder(root, tmp);
		 int i = 0;
		 for(int e: tmp)
			 pre[i++] = e;
		 tmp.clear();
		 inorder(root, tmp);
		 i = 0;
		 for(int e: tmp)
			 in[i++] = e;
	}
	//TC:O(n ^ 2)
	//SC:O(n)
	public static TreeNode deserialize1(int[] pre, int[] in) {
		return auxDeserialize1(pre, in, 0, pre.length-1, 0);
	}
	private static TreeNode auxDeserialize1(int[] pre, int[] in, int in_start, int in_end, int pre_start) {
		if(in_start > in_end) return null;
		TreeNode tmp = new TreeNode(pre[pre_start]);
		if(in_start == in_end) return tmp;
		int i;
		for(i = in_start; i <= in_end; ++i) {
			if(in[i] == pre[pre_start])
				break;
		}
		tmp.left = auxDeserialize1(pre, in, in_start, i-1, pre_start+1);
		tmp.right = auxDeserialize1(pre, in, i+1, in_end, pre_start + (i-in_start+1));
		return tmp;
	}
	
	//TC:O(n)
	//SC:O(n + n) ~ O(n)
	public static TreeNode deserialize2(int[] pre, int[] in) {
		HashMap<Integer, Integer> in_map = new HashMap<Integer, Integer>();
		for(int i = 0; i < in.length; ++i)
			in_map.put(in[i], i);
		return auxDeserialize2(pre, in, 0, pre.length-1, 0, in_map);
	}
	private static TreeNode auxDeserialize2(int[] pre, int[] in, int in_start, int in_end, int pre_start, HashMap<Integer, Integer> in_map) {
		if(in_start > in_end) return null;
		TreeNode tmp = new TreeNode(pre[pre_start]);
		if(in_start == in_end) return tmp;
		int i = in_map.get(pre[pre_start]); 
		tmp.left = auxDeserialize2(pre, in, in_start, i-1, pre_start+1, in_map);
		tmp.right = auxDeserialize2(pre, in, i+1, in_end, pre_start + (i-in_start+1), in_map);
		return tmp;
	}
	
	//TC:O(n)
	//SC:O(n)
	//TODO: level order based serialization
	public static void serialize2(List<Integer> level) {
		
	}
	//TC:O(n)
	//SC:O(1)
	//TODO: construct tree based on level order
	public static TreeNode deserialize(List<Integer> level) {
		return null;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createTree2(n);
		BinaryTreeUtils.display1(root);
		int[] pre = new int[n];
		int[] in = new int[n];
		serialize1(root, pre, in);
		System.out.println(Arrays.toString(pre));
		System.out.println(Arrays.toString(in));
		root = deserialize2(pre, in);
		BinaryTreeUtils.display1(root);
	}

}

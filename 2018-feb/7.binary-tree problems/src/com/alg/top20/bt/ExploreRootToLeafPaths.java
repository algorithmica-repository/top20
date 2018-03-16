package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.List;

public class ExploreRootToLeafPaths {

	public static List<String> binaryTreePaths1(TreeNode root){
		List<String> paths = new LinkedList<String>();
		auxTreePaths(root, "", paths);
		return paths;
	}
	private static void auxTreePaths(TreeNode root, String path, List<String> paths) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			path = path + "->"+root.data;
			paths.add(path);
			return;
		}
		auxTreePaths(root.left, path+"->"+root.data, paths);
		auxTreePaths(root.right, path+"->"+root.data, paths);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		System.out.println(binaryTreePaths1(root));

	}

}

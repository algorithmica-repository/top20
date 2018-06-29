package com.alg.top20.bt;


public class Permutations {

	private static boolean isValid1(String path) {
		for(int i = 0; i < path.length(); ++i) {
			for(int j = i+1; j < path.length(); ++j) {
				if(path.charAt(i) == path.charAt(j))
					return false;
			}
		}
		return true;
	}
	public static void permutation1(String in){
		auxPermutation1(0, in, "");		
	}
	private static void auxPermutation1(int d, String in, String path) {
		if(d == in.length()) {
			if(isValid1(path)) 
				System.out.println(path);
			return;
		}
		for(int i = 0; i < in.length(); ++i) 
			auxPermutation1(d+1, in, path + in.charAt(i));
	}
	
	private static boolean isValid2(String path, char c) {
		if(path.contains(c+"")) return false;
		return true;
	}
	public static void permutation2(String in){
		auxPermutation2(0, in, "");		
	}
	private static void auxPermutation2(int d, String in, String path) {
		if(d == in.length()) {
			System.out.println(path);
			return;
		}
		for(int i = 0; i < in.length(); ++i) {
			if(isValid2(path, in.charAt(i))) 
				auxPermutation2(d+1, in, path + in.charAt(i));
		}
	}
	public static void main(String[] args) {
		permutation1(args[0]);
	}


}

package com.alg.top20.bt;

public class PalPartitions {

	public static boolean isValid1(String path) {
		String[] tokens = path.split(",");
		//System.out.println(Arrays.toString(tokens));
		for(int i = 0; i < tokens.length; ++i) {
			if(isPalindrome(tokens[i].trim()) == false) return false;
		}
		return true;
	}
	public static void palPartition1(String in) {
		auxPartition1(in, "");
	}
	private static void auxPartition1(String in, String path)  {
		if(in.length() == 0) {
			if(isValid1(path))
				System.out.println(path);
			return;
		}
		for(int i = 0; i < in.length(); ++i) {
			String tmp = in.substring(0, i+1);
			auxPartition1(in.substring(i+1), path+ "," + tmp);
		}
	}
	
	public static boolean isPalindrome(String s) {
		for(int i = 0, j = s.length()-1; i < j; ++i, --j)
			if(s.charAt(i) != s.charAt(j)) return false;
		return true;
	}
	public static void palPartition2(String in) {
		auxPartition2(in, "");
	}
	private static void auxPartition2(String in, String path)  {
		if(in.length() == 0) {
			System.out.println(path);
			return;
		}
		for(int i = 0; i < in.length(); ++i) {
			String tmp = in.substring(0, i+1);
			if(isPalindrome(tmp)) 
				auxPartition2(in.substring(i+1), path+ "+" + tmp);
		}
	}
	public static void main(String[] args) {
		palPartition1(args[0]);
		System.out.println();
		palPartition2(args[0]);
	}

}

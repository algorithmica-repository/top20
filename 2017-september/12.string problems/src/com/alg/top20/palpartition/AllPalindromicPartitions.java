package com.alg.top20.palpartition;

public class AllPalindromicPartitions {

	//backtracking
	public static void allPalPartitions1(String s) {
		auxPalPartitions1(s, "");
	}
	private static void auxPalPartitions1(String s, String res) {
		if(s.length() == 0) {
			System.out.println(res);
			return;
		}			
		for(int i = 0; i < s.length(); ++i) {
			String tmp = s.substring(0, i+1);
			if(isPalindrome1(tmp))
				auxPalPartitions1(s.substring(i+1), res+"+"+tmp);
		}		
	}	
	private static boolean isPalindrome1(String s) {
		int i = 0, j = s.length()-1; 
		while(i < j) {
			if(s.charAt(i) != s.charAt(j)) 
				return false;
			++i;
			--j;
		}
		return true;
	}
	
	public static void main(String[] args) {
		allPalPartitions1(args[0]);
	}

}

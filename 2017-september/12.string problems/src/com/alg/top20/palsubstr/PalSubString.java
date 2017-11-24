package com.alg.top20.palsubstr;

public class PalSubString {

	private static boolean isPalindrome(String s, int i, int j) {
		while(i < j) {
			if(s.charAt(i) != s.charAt(j)) 
				return false;
			++i;
			--j;
		}
		return true;
	}
	public static int longPalSubstr1(String s) {
		int max = 0;
		for(int i = 0; i < s.length(); ++i) {
			for(int j = i; j < s.length(); ++j) {
				System.out.println(s.substring(i,j+1));
				if(isPalindrome(s, i, j))
					max = Math.max(max, j-i+1);
			}
		}		
		return max;
	}
	public static void main(String[] args) {
		System.out.println(longPalSubstr1(args[0]));
	}

}

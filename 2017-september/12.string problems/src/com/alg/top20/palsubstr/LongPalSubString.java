
package com.alg.top20.palsubstr;

import java.util.Arrays;

public class LongPalSubString {

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
	
	//TC:O(n^2)
	//SC:O(n^2) -> O(n)
	//Recursion->Dynamic programming
	public static int longPalSubstr2(String s) {
		int n = s.length();
		int max = 1;
		
		boolean[][] mem = new boolean[n+1][n+1];
		for(int i = 1; i <= n; ++i)
			mem[i][i] = true;
		for(int i = n-1; i >= 1; --i) {
			for(int j = i+1; j <= n; ++j) {
				if(s.charAt(i-1) == s.charAt(j-1)) {
					mem[i][j] = mem[i+1][j-1];
					if(mem[i][j] == true)
						max = Math.max(max, j-i+1);
				}
				else 
					mem[i][j] = false;
			}
		}	
		printMemory(mem);
		return max;
	}
	//TC:O(n^2)
	//SC:O(1) 
	//Expand around each index as centre
	public static int longPalSubstr3(String s) {
		int max = 0;
		for(int i = 0; i < s.length(); ++i) {
			int odd = expandCenter(i, i, s);
			int even = expandCenter(i, i+1, s);
			max = Math.max(max, Math.max(odd, even));
		}
		return max;
	}
	private static int expandCenter(int l, int r, String s) {
		while(l >= 0 && r < s.length()) {
			if(s.charAt(l) == s.charAt(r)) {
				--l;
				++r;
			} else
				break;
		}
		return r-l-1;
	}
	
	private static void printMemory(boolean[][] mem) {
		for(boolean[] tmp: mem)
			System.out.println(Arrays.toString(tmp));
	}
	
	public static void main(String[] args) {
		//System.out.println(longPalSubstr2(args[0]));
		System.out.println(longPalSubstr3(args[0]));
	}

}

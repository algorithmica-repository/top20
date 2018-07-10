package com.alg.top20.string;

import java.util.Arrays;

public class EditDistance {

	public static int editDistance1(String s1, String s2) {
		return auxEditDistance1(s1.length(), s2.length(), s1, s2);
	}
	private static int auxEditDistance1(int i, int j, String s1, String s2) {
		if(i == 0) return j;
		if(j == 0) return i;
		if(s1.charAt(i-1) == s2.charAt(j-1)) 
			return auxEditDistance1(i-1, j-1, s1, s2);
		else {
			int icost = auxEditDistance1(i, j-1, s1, s2)+1;
			int rcost = auxEditDistance1(i-1, j-1, s1, s2)+1;
			int dcost = auxEditDistance1(i-1, j, s1, s2)+1;
			return Math.min(Math.min(icost, rcost), dcost);
		}
	}
	
	public static int editDistance2(String s1, String s2) {
		int[][] mem = new int[s1.length()+1][s2.length()+1];
		auxEditDistance2(s1.length(), s2.length(), s1, s2, mem);
		return mem[s1.length()][s2.length()];
	}
	private static int auxEditDistance2(int i, int j, String s1, String s2, int[][] mem) {
		if(i == 0) return j;
		if(j == 0) return i;
		if(mem[i][j] != 0) return mem[i][j];
		if(s1.charAt(i-1) == s2.charAt(j-1)) 
			return mem[i][j] = auxEditDistance2(i-1, j-1, s1, s2, mem);
		else {
			int icost = auxEditDistance2(i, j-1, s1, s2,mem)+1;
			int rcost = auxEditDistance2(i-1, j-1, s1, s2, mem)+1;
			int dcost = auxEditDistance2(i-1, j, s1, s2, mem)+1;
			return mem[i][j] = Math.min(Math.min(icost, rcost), dcost);
		}
	}
	
	private static void printOptimalPath(int i, int j, String s1, String s2, int[][] mem) {
		if( i == 0 || j == 0) return;
		if(s1.charAt(i-1) == s2.charAt(j-1))
			printOptimalPath(i-1, j-1, s1, s2, mem);
		else {
			int minr = i;
			int minc = j-1;
			char edit = 'I';
			if(mem[i-1][j-1] < mem[minr][minc]) {
				minr = i-1;
				minc = j-1;
				edit = 'R';
			}
			if(mem[i-1][j] < mem[minr][minc]) {
				minr = i-1;
				minc = j;
				edit = 'D';
			}
			printOptimalPath(minr, minc, s1, s2, mem);
			System.out.println(edit);
		}
	}
	private static void printMemory(int[][] mem) {
		for(int[] tmp:mem) {
			System.out.println(Arrays.toString(tmp));
		}
	}
	public static int editDistance3(String s1, String s2) {
		int[][] mem = new int[s1.length()+1][s2.length()+1];
		for(int j = 0; j <= s2.length(); ++j)
			mem[0][j] = j;
		for(int i = 1; i <= s1.length(); ++i)
			mem[i][0] = i;
		for(int i = 1; i <= s1.length(); ++i) {
			for(int j = 1; j <= s2.length(); ++j) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) 
					mem[i][j] = mem[i-1][j-1];
				else {
					int icost = mem[i][j-1]+1;
					int rcost = mem[i-1][j-1]+1;
					int dcost = mem[i-1][j]+1;
					mem[i][j] = Math.min(Math.min(icost, rcost), dcost);
				}
			}
		}
		printMemory(mem);
		printOptimalPath(s1.length(), s2.length(), s1, s2, mem);
		return mem[s1.length()][s2.length()];
	}
	public static void main(String[] args) {
		//System.out.println(editDistance2(args[0], args[1]));
		System.out.println(editDistance3(args[0], args[1]));
	}

}
; 
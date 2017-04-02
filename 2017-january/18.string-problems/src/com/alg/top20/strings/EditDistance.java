package com.alg.top20.strings;

import java.util.Random;

public class EditDistance {

	private static int auxEditDistance1(int i, int j, String s1, String s2) {
		if(i < 0) return j+1;
		if(j < 0) return i+1;
		if(s1.charAt(i) != s2.charAt(j)) {
			int ins_cost = auxEditDistance1(i, j-1, s1, s2) + 1;
			int rep_cost = auxEditDistance1(i-1, j-1, s1, s2) + 1;
			int del_cost = auxEditDistance1(i-1, j, s1, s2) + 1;
			return Math.min(ins_cost, Math.min(rep_cost, del_cost));
		} else {
			return auxEditDistance1(i-1, j-1, s1, s2);
		}
	}
	public static int editDistance1(String s1, String s2) {
		return auxEditDistance1(s1.length()-1, s2.length()-1,s1,s2);
	}
	
	private static int auxEditDistance2(int i, int j, String s1, String s2, int[][] mem) {
		if(i < 0) return j+1;
		if(j < 0) return i+1;
		if(mem[i][j] != -1) return mem[i][j];
		if(s1.charAt(i) != s2.charAt(j)) {
			int ins_cost = auxEditDistance2(i, j-1, s1, s2, mem) + 1;
			int rep_cost = auxEditDistance2(i-1, j-1, s1, s2, mem) + 1;
			int del_cost = auxEditDistance2(i-1, j, s1, s2, mem) + 1;
			return mem[i][j] = Math.min(ins_cost, Math.min(rep_cost, del_cost));
		} else {
			return mem[i][j] = auxEditDistance2(i-1, j-1, s1, s2, mem);
		}
	}
	public static int editDistance2(String s1, String s2) {
		int[][] mem = new int[s1.length()][s2.length()];
		for(int i = 0; i < s1.length(); ++i) {
			for(int j = 0; j < s2.length(); ++j) {
				mem[i][j] = -1;
			}
		}
		auxEditDistance2(s1.length()-1, s2.length()-1,s1,s2, mem);
		return mem[s1.length()-1][s2.length()-1];
	}
	
	private static int boundary_check(int i, int j, int[][] mem) {
		if(i < 0) return j + 1;
		if(j < 0) return i + 1;
		return mem[i][j];
	}
	public static int editDistance3(String s1, String s2) {
		int[][] mem = new int[s1.length()][s2.length()];
		for(int i = 0; i < s1.length(); ++i) {
			for(int j = 0; j < s2.length(); ++j) {
				if(s1.charAt(i) != s2.charAt(j)) {
					mem[i][j] = Math.min(boundary_check(i-1,j, mem), Math.min(boundary_check(i-1,j-1, mem), boundary_check(i, j-1, mem))) + 1;
				} else {
					mem[i][j] = boundary_check(i-1,j-1,mem);
				}
			}
		}
		return mem[s1.length()-1][s2.length()-1];
	}
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		Random r = new Random(100);
		String s1 = "";		
		for(int i = 0; i < m; ++i) 
			s1 = s1  + (char)('a'+ r.nextInt(26));
		String s2 = "";
		for(int i = 0; i < n; ++i) 
			s2 = s2  + (char)('a'+ r.nextInt(26));
		//System.out.println(s1);
		//System.out.println(s2);
		//System.out.println(editDistance2(s1, s2));
		System.out.println(editDistance3(s1, s2));

	}

}

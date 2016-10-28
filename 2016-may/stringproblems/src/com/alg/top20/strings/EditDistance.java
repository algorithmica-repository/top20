package com.alg.top20.strings;

public class EditDistance {

	private static int auxdist1(int i, int j, String s1, String s2) {
		if(i == -1) return j+1;
		if(j == -1) return i+1;
		if(s1.charAt(i) == s2.charAt(j))
			return auxdist1(i-1, j-1, s1, s2);
		else {
			int repcost = 1 + auxdist1(i-1, j-1, s1, s2);
			int addcost = 1 + auxdist1(i, j-1, s1, s2);
			int remcost = 1 + auxdist1(i - 1, j, s1, s2);
			return Math.min(Math.min(addcost, repcost), remcost);
		}
	}
	public static int editdistance1(String s1, String s2) {
		return auxdist1(s1.length()-1, s2.length()-1,s1,s2);
	}
	
	private static int auxdist2(int i, int j, String s1, String s2, int[][] mem) {
		if(i == -1) return j+1;
		if(j == -1) return i+1;
		if(mem[i][j] != -1) return mem[i][j];
		if(s1.charAt(i) == s2.charAt(j)) 
			return mem[i][j] = auxdist2(i-1, j-1, s1, s2, mem);
		else {
			int repcost = 1 + auxdist2(i-1, j-1, s1, s2, mem);
			int addcost = 1 + auxdist2(i, j-1, s1, s2, mem);
			int remcost = 1 + auxdist2(i - 1, j, s1, s2, mem);
			return mem[i][j] = Math.min(Math.min(addcost, repcost), remcost);
		}
	}
	public static int editdistance2(String s1, String s2) {
		int[][] mem = new int[s1.length()][s2.length()];
		for(int i = 0; i <  s1.length(); ++i) {
			for(int j = 0; j < s2.length(); ++j) {
				mem[i][j] = -1;
			}
		}
		return auxdist2(s1.length()-1, s2.length()-1,s1,s2, mem);
	}
	
	private static int cost(int i, int j, int[][] mem) {
		if(i < 0)  	return j+1;
		if(j < 0) 	return i+1;
		return mem[i][j];
	}
	
	public static int editdistance3(String s1, String s2) {
		int[][] mem = new int[s1.length()][s2.length()];
		for(int i = 0; i <  s1.length(); ++i) {
			for(int j = 0; j < s2.length(); ++j) {
				if(s1.charAt(i) == s2.charAt(j))
					mem[i][j] = cost(i-1,j-1,mem);
				else {
					int repcost = 1 + cost(i-1,j-1,mem);
					int addcost = 1 + cost(i,j-1,mem);
					int remcost = 1 + cost(i-1,j,mem);
					mem[i][j] = Math.min(Math.min(addcost, repcost), remcost);
				}
			}
		}
		return mem[s1.length()-1][s2.length()-1];
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		String s1 = "";
		String s2 = "";
		for(int i = 0; i < n; ++i)
			s1 = s1 + 'a';
		for(int i = 0; i < m; ++i)
			s2 = s2 + 'z';
		System.out.println(editdistance3(s1, s2));
	}

}

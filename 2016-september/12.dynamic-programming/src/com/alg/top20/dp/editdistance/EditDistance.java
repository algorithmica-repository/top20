package com.alg.top20.dp.editdistance;

public class EditDistance {

	private static int auxEditDistance1(int i, int j, String s1, String s2) {
		if(i < 0 && j < 0) return 0;
		if(i < 0) return j+1;
		if(j < 0) return i+1;
		if(s1.charAt(i) == s2.charAt(j))
			return auxEditDistance1(i-1, j-1, s1, s2);
		else {
			int rcost = auxEditDistance1(i-1, j-1, s1, s2) + 1;
			int dcost = auxEditDistance1(i-1, j, s1, s2) + 1;
			int icost = auxEditDistance1(i, j-1, s1, s2) + 1;
			return Math.min(Math.min(rcost, dcost), icost);
		}
	}
	
	public static int editDistance1(String s1, String s2) {
		return auxEditDistance1(s1.length()-1, s2.length()-1, s1, s2);
	}
	private static int getCellCost(int x, int y, int[][] mem) {
		if(x < 0 || y < 0) return 0;
		return mem[x][y];
	}
	private static int auxEditDistance2(int i, int j, String s1, String s2, int[][] mem) {
		if(i < 0 && j < 0) return 0;
		if(i < 0) return j+1;
		if(j < 0) return i+1;
		if(s1.charAt(i) == s2.charAt(j)) {
			int ret = getCellCost(i-1, j-1, mem);
			if(ret == -1) 
				ret = mem[i-1][j-1] = auxEditDistance2(i-1, j-1, s1, s2, mem);
			return ret;
		}
		else {
			int rcost = getCellCost(i-1, j-1, mem);
			if(rcost == -1) 
				rcost = mem[i-1][j-1] = auxEditDistance2(i-1, j-1, s1, s2, mem);
			
			int dcost = getCellCost(i-1, j, mem);
			if(dcost == -1) 
				dcost = mem[i-1][j] = auxEditDistance2(i-1, j, s1, s2, mem);
			
			int icost = getCellCost(i, j-1, mem);
			if(icost == -1) 
				icost = mem[i][j-1] = auxEditDistance2(i, j-1, s1, s2, mem);
			return Math.min(Math.min(rcost, dcost), icost) + 1;
		}
	}
	
	public static int editDistance2(String s1, String s2) {
		int[][] mem = new int[s1.length()][s2.length()];
		for(int i = 0; i < s1.length(); ++i) {
			for(int j = 0; j < s2.length(); ++j) {
				mem[i][j] = -1;
			}
		}
		return auxEditDistance2(s1.length()-1, s2.length()-1, s1, s2, mem);
	}
	
	public static int editDistance3(String s1, String s2) {
		int[][] mem = new int[s1.length()][s2.length()];
		for(int i = 0; i < s1.length(); ++i) {
			for(int j = 0; j < s2.length(); ++j) {
				if(s1.charAt(i) == s2.charAt(j)) {
					mem[i][j] = getCellCost(i-1, j-1, mem);
				} else {
					int rcost = getCellCost(i-1, j-1, mem);
					int dcost = getCellCost(i-1, j, mem);
					int icost = getCellCost(i, j-1, mem);
					mem[i][j] = Math.min(Math.min(rcost, dcost), icost) + 1;
				}
			}
		}
		return mem[s1.length()-1][s2.length()-1];
	}
	public static void main(String[] args) {
		String s1 = "public static void main fdasjfld fdjfdk fdjkfjd fdjkfj ds";
		String s2 = "static public main void jfdksfj djk fdkjfd jf dfjdk jfd fj sjkfd fjkjadfdsjfdf jfkjdf";
		//System.out.println(editDistance1(s1, s2));
		System.out.println(editDistance3(s1, s2));

	}

}

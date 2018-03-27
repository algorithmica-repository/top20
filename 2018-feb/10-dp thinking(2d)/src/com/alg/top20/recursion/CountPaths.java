package com.alg.top20.recursion;

public class CountPaths {

	//TC:O(2 ^ m+n)  SC:O(m+n)
	public static int countPaths1(int m, int n) {
		MyInteger count = new MyInteger(0);
		auxCountPaths1(1, 1, m, n, count);
		return count.get();
	}
	private static void auxCountPaths1(int r, int c, int m, int n, MyInteger count) {
		if(r > m || c > n) return;
		if(r == m && c == n)  { 
			count.set(count.get()+1);
			return;
		}
		auxCountPaths1(r, c+1, m, n, count);
		auxCountPaths1(r+1, c, m, n, count);
	}
	
	public static int countPaths2(int i, int j) {
		if(i <= 0 || j <= 0) return 0;		
		if(i == 1 && j == 1) return 1;
		int top_cell_paths = countPaths2(i-1, j);
		int left_cell_paths = countPaths2(i, j-1);
		return top_cell_paths + left_cell_paths;
	}
	
	public static int countPaths3(int m, int n) {
		int[][] mem = new int[m+1][n+1];
		auxCountPaths3(m, n, mem);
		return mem[m][n];
	}
	private static int auxCountPaths3(int i, int j, int[][] mem) {
		if(i <= 0 || j <= 0) return 0;		
		if(i == 1 && j == 1) return 1;
		if(mem[i][j] != 0) return mem[i][j];
		int top_cell_paths = auxCountPaths3(i-1, j, mem);
		int left_cell_paths = auxCountPaths3(i, j-1, mem);
		mem[i][j] = top_cell_paths + left_cell_paths;
		return mem[i][j];
	}
	
	public static int countPaths4(int m, int n) {
		int[][] mem = new int[m+1][n+1];
		for(int i = 0; i <= m; ++i)
			mem[i][0] = 0;
		for(int j = 0; j <= n; ++j)
			mem[0][j] = 0;
		mem[1][1] = 1;
		for(int i = 1; i <= m; ++i){
			for(int j = 1; j <= n; ++j) {
				if(i == 1 && j == 1) continue;
				mem[i][j] = mem[i-1][j] + mem[i][j-1];
			}
		}
		return mem[m][n];
	}
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		System.out.println(countPaths4(m, n));
	}

}

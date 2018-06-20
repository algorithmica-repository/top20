package com.alg.top20.optimization;
import java.util.Arrays;
import java.util.Random;


public class MaximumSumInGrid {

	  public static int maxSum1(int[][] in) {
		  return auxSum1(in.length, in.length,in);
	  }
	  private static int auxSum1(int i, int j, int[][] in) {
		  if(i == 0 || j == 0) return 0;
		  int topCell = auxSum1(i-1, j, in);
		  int leftCell = auxSum1(i, j-1, in);
		  return Math.max(topCell, leftCell) + in[i-1][j-1];
	  }
	  
	  public static int maxSum2(int[][] in) {
		  int[][] mem = new int[in.length+1][in.length+1];
		  auxSum2(in.length, in.length, in, mem);
		  return mem[in.length][in.length];
	  }
	  private static int auxSum2(int i, int j, int[][] in, int[][] mem) {
		  if(i == 0 || j == 0) return 0;
		  if(mem[i][j] != 0) return mem[i][j];
		  int topCell = auxSum2(i-1, j, in, mem);
		  int leftCell = auxSum2(i, j-1, in, mem);
		  mem[i][j] = Math.max(topCell, leftCell) + in[i-1][j-1];
		  for(int k = 0; k <= in.length ; ++k)
			System.out.println(Arrays.toString(mem[k]));
		  System.out.println();
		  return mem[i][j];
	  }
	  //TC:O(n)  SC:O(n)
	  private static void getOptimalPath(int i, int j, int[][] mem) {
		  if(i == 1 && j == 1) return;
		  if(mem[i-1][j] > mem[i][j-1]) {
			  getOptimalPath(i-1, j, mem);
			  System.out.println("(" + (i-1) + "," + j + ")");
		  } else {
			  getOptimalPath(i, j-1, mem);
			  System.out.println("(" + i + "," + (j-1) + ")");
		  }
	  }
	  public static int maxSum3(int[][] in) {
		  int[][] mem = new int[in.length+1][in.length+1];
		  for(int i = 0; i <= in.length; ++i) {
			  	mem[0][i] = 0;
		  		mem[i][0] = 0;
		  }
		  for(int i = 1; i <= in.length; ++i) {
			  for(int j = 1; j <= in.length; ++j) {
				  int topCell = mem[i-1][j];
				  int leftCell = mem[i][j-1];
				  mem[i][j] = Math.max(topCell, leftCell) + in[i-1][j-1];
			  }
		  }
		  for(int k = 0; k <= in.length ; ++k)
				System.out.println(Arrays.toString(mem[k]));
		  System.out.println();
		  getOptimalPath(in.length, in.length, mem);
		  return mem[in.length][in.length];
	  }
	  
	  public static void main(String[] args) {
		  int n = Integer.parseInt(args[0]);
		  Random r = new Random(100);
		  int[][] in = new int[n][n];
		  for(int i = 0; i < n; ++i)
			  for(int j = 0; j < n; ++j)
				in[i][j] = r.nextInt(n) + 1;
		  for(int i = 0; i < n; ++i)
			System.out.println(Arrays.toString(in[i]));
		  //System.out.println(maxSum1(in));
		  //System.out.println(maxSum2(in));
		  System.out.println(maxSum3(in));
		
	  }
}

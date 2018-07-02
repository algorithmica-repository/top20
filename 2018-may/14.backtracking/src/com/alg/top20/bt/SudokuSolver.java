package com.alg.top20.bt;
import java.util.Arrays;


public class SudokuSolver {

	public static boolean isValid1(int[][] in) {
		return true;
	}
	public static void sudokusolver1(int[][] in) {
		auxSolver1(0, 0, in);
	}
	private static void auxSolver1(int r, int c, int[][] in) {
		if(r == 9) {
			if(isValid1(in)) {
				for(int[] tmp:in) 
					System.out.println(Arrays.toString(tmp));
				System.out.println();
			}
			return;
		}
		if(in[r][c] != 0) {
			auxSolver1(c==8?r+1:r, (c+1)%9, in);
		} else {
			for(int d = 1; d <= 9; ++d) {
				in[r][c] = d;
				auxSolver1(c==8?r+1:r, (c+1)%9, in);
			}
			//update the cell back to 0 to try 1-9
			in[r][c] = 0;
		}
	}
	
	public static boolean isValid2(int[][] in, int r, int c, int d) {
		for(int j = 0; j < 9; ++j)
			if(in[r][j] == d) return false;
		for(int i = 0; i < 9; ++i)
			if(in[i][c] == d) return false;
		int sr = r / 3 * 3;
		int sc = c / 3 * 3;
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if(in[sr+i][sc+j] == d) return false;
			}
		}
		return true;
	}
	public static void sudokusolver2(int[][] in) {
		auxSolver2(0, 0, in);
	}
	private static void auxSolver2(int r, int c, int[][] in) {
		if(r == 9) {
			for(int[] tmp:in) 
				System.out.println(Arrays.toString(tmp));
			System.out.println();
			return;
		}
		if(in[r][c] != 0) {
			auxSolver2(c==8?r+1:r, (c+1)%9, in);
		} else {
			for(int d = 1; d <= 9; ++d) {
				if(isValid2(in, r, c, d)) {
					in[r][c] = d;
					auxSolver2(c==8?r+1:r, (c+1)%9, in);
				}
			}
			//update the cell back to 0 to try 1-9
			in[r][c] = 0;
		}
	}
	
	public static void main(String[] args) {
		int[][] in = 
		{ 	{0,0,7,0,0,0,0,0,0},
			{0,0,0,6,0,0,0,9,8},
			{0,0,0,0,1,0,2,0,0},
			{0,0,4,0,0,7,0,3,0},
			{8,2,0,0,0,3,4,7,0},
			{7,0,0,0,0,4,0,0,6},
			{0,9,0,3,0,0,7,4,0},
			{4,0,5,0,0,0,0,0,0},
			{0,6,0,0,0,8,0,0,0}
		};
		sudokusolver2(in);
	}

}

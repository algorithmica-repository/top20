package com.alg.top20.bt.sudoku;

import java.util.Arrays;

public class SudokuSolver {

	//nested loops
	public static void sudokuSolver1(int[][] in) {
		for (int c00 = 1; c00 <= 9; ++c00) {
			for (int c01 = 1; c01 <= 9; ++c01) {
				// 81 times......
				// if(isValid1(c01, c02,...))
			}
		}
	}

	//recursion
	public static void sudokuSolver2(int[][] in) {
		auxSolver2(0, 0, in);
	}
	private static boolean isValid2(int[][] in) {
		return true;
	}
	private static void auxSolver2(int r, int c, int[][] in) {
		if (r == 9) {
			if (isValid2(in)) {
				for (int[] row : in)
					System.out.println(Arrays.toString(row));
				System.out.println();
			}
			return;
		}
		if (in[r][c] != 0) {
			auxSolver2(c == 8 ? r + 1 : r, (c + 1) % 9, in);
		}
		else {
			for (int d = 1; d <= 9; ++d) {
				in[r][c] = d;
				auxSolver2(c == 8 ? r + 1 : r, (c + 1) % 9, in);
			}
			in[r][c] = 0;
		}
	}
	
	//backtracking
	public static void sudokuSolver3(int[][] in) {
		auxSolver3(0, 0, in);
	}
	private static boolean isValid3(int[][] in, int r, int c, int d) {
		//row check
		for(int j = 0; j < 9; ++j)
			if(in[r][j] == d) return false;
		//col check
		for(int i = 0; i < 9; ++i)
			if(in[i][c] == d) return false;
		//box check
		int sr = r / 3 * 3;
		int sc = c / 3 * 3;
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if(in[sr+i][sc+j] == d)
					return false;
			}
		}
		return true;
	}

	private static void auxSolver3(int r, int c, int[][] in) {
		if (r == 9) {
			for (int[] row : in)
				System.out.println(Arrays.toString(row));
			System.out.println();
			return;
		}
		if (in[r][c] != 0) {
			auxSolver3(c == 8 ? r + 1 : r, (c + 1) % 9, in);
		}
		else {
			for (int d = 1; d <= 9; ++d) {
				if (isValid3(in, r, c, d)) {
					in[r][c] = d;
					auxSolver3(c == 8 ? r + 1 : r, (c + 1) % 9, in);
				}
			}
			in[r][c] = 0;
		}
	}

	public static void main(String[] args) {
		int[][] in = 
			{ 
				{0,9,0,7,0,0,0,0,6},
				{0,1,0,0,0,4,0,0,0},
				{0,0,0,0,6,8,0,0,3},
				{4,0,7,0,0,0,9,0,0},
				{0,0,0,0,0,6,0,5,2},
				{0,0,0,0,0,1,0,0,8},
				{2,6,0,4,0,0,0,0,0},
				{3,0,0,6,2,0,0,8,0},
				{0,0,8,0,0,7,0,0,0}
			};
		
		sudokuSolver3(in);
	}

}

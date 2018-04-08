package com.alg.top20.bt;

import java.util.Arrays;

public class SudokuSolver {

	//complete search
	public static void sudokuSolver1(int[][] in) {
		auxSolver1(0, 0, in);
	}
	private static boolean isValid1(int[][] in) {
		//todo: check rows, columns, boxes
		return true;
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
			in[r][c] = 0;
		}
	}
	
	//backtracking
	public static void sudokuSolver2(int[][] in) {
		auxSolver2(0, 0, in);
	}
	private static boolean isValid2(int[][] in, int r, int c, int d) {
		//row check
		for(int j = 0; j < 9; ++j)
			if(in[r][j] == d) return false;
		//column check
		for(int i = 0; i < 9; ++i) 
			if(in[i][c] == d) return false;
		//box check
		int sr = r/3*3;
		int sc = c/3*3;
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if(in[sr+i][sc+j] == d) return false;
			}
		}
		//add heuristics: logic derived from solving more puzzles
		return true;
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
			in[r][c] = 0;
		}
	}
	public static void main(String[] args) {
		int[][] in = 
		{ 	{1,0,0,0,5,0,0,0,9},
			{0,0,0,4,0,9,0,0,0},
			{0,0,0,3,8,6,0,0,0},
			{5,9,0,0,0,0,0,6,8},
			{4,0,0,8,9,2,0,0,7},
			{0,0,0,0,0,0,0,0,0},
			{0,0,1,7,0,5,8,0,0},
			{0,3,0,0,0,0,0,1,0},
			{9,8,5,0,4,0,7,3,2}
		};
		sudokuSolver2(in);
	}

}

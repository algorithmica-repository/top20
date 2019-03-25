package com.alg.top20.puzzles;

import java.util.Arrays;

public class SudokuSolver {

	public static void solver1(int[][] in) {
		auxSolver1(0, 0, in);
	}

	private static boolean isValid1(int[][] in) {
		for(int i = 0; i < 9; ++i) {
			for(int j = 0; j < 9; ++j) {
				int d = in[i][j];
				in[i][j] = 0;
				if(!isValid2(i, j, d, in)) return false;
				in[i][j] = d;
			}
		}
		return true;
	}

	private static void auxSolver1(int i, int j, int[][] in) {
		if (i == 9) {
			if (isValid1(in)) {
				for (int[] tmp : in)
					System.out.println(Arrays.toString(tmp));
				System.out.println();
			}
			return;
		}
		if (in[i][j] != 0) {
			auxSolver1(j == 8 ? i + 1 : i, (j + 1) % 9, in);
		} else {
			for (int d = 1; d <= 9; ++d) {
				in[i][j] = d;
				auxSolver1(j == 8 ? i + 1 : i, (j + 1) % 9, in);
			}
			in[i][j] = 0;
		}
	}

	public static void solver2(int[][] in) {
		auxSolver2(0, 0, in);
	}

	private static boolean isValid2(int i, int j, int d, int[][] in) {
		for(int c = 0; c < 9; ++c) 
			if(in[i][c] == d) return false;
		for(int r = 0; r < 9; ++r)
			if(in[r][j] == d) return false;
		int sr = i/3*3;
		int sc = j/3*3;
		for(int r = 0;  r < 3; ++r)  {
			for(int c = 0; c < 3;  ++c) {
				if(in[sr+r][sc+c] == d) return false;
			}
		}
		//add heuristics
		return true;
	}

	private static void auxSolver2(int i, int j, int[][] in) {
		if (i == 9) {
			for (int[] tmp : in)
				System.out.println(Arrays.toString(tmp));
			System.out.println();
			return;
		}
		if (in[i][j] != 0) {
			auxSolver2(j == 8 ? i + 1 : i, (j + 1) % 9, in);
		} else {
			for (int d = 1; d <= 9; ++d) {
				if (isValid2(i, j, d, in)) {
					in[i][j] = d;
					auxSolver2(j == 8 ? i + 1 : i, (j + 1) % 9, in);
				}
			}
			in[i][j] = 0;
		}
	}

	public static void main(String[] args) {
		int[][] in = { 
				{ 2, 7, 0, 0, 8, 0, 0, 5, 0 },
				{ 0, 0, 0, 3, 0, 2, 0, 0, 6 }, 
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 8, 0, 0, 9, 0, 0, 0, 7 }, 
				{ 4, 0, 0, 0, 0, 0, 0, 8, 0 },
				{ 7, 0, 3, 0, 0, 0, 6, 0, 0 }, 
				{ 0, 1, 0, 0, 0, 0, 0, 0, 2 },
				{ 0, 0, 0, 0, 0, 5, 0, 0, 0 }, 
				{ 0, 0, 9, 6, 0, 8, 4, 1, 0 } 
			};
		solver2(in);
	}

}

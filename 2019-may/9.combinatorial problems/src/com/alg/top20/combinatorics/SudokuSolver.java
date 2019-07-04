package com.alg.top20.combinatorics;

import java.util.Arrays;

public class SudokuSolver {

	public static void sudokuSolver1(int[][] in) {
		int[][] out = new int[9][9];
		auxSolver1(0, 0, in, out);
	}

	private static boolean isValid1(int[][] out) {
		return true;
	}

	private static void auxSolver1(int r, int c, int[][] in, int[][] out) {
		if (r == 9) {
			if (isValid1(out)) {
				for (int[] tmp : out)
					System.out.println(Arrays.toString(tmp));
				System.out.println();
			}
			return;
		}
		if (in[r][c] != 0) {
			out[r][c] = in[r][c];
			auxSolver1(c == 8 ? r + 1 : r, (c + 1) % 9, in, out);
		} else {
			for (int d = 1; d <= 9; ++d) {
				out[r][c] = d;
				auxSolver1(c == 8 ? r + 1 : r, (c + 1) % 9, in, out);
			}
		}
	}
	
	public static void sudokuSolver2(int[][] in) {
		int[][] out = new int[9][9];
		auxSolver2(0, 0, in, out);
	}

	private static boolean isValid2(int r, int c, int d, int[][] out) {
		for(int i = 0; i < 9; ++i)
			if(out[i][c] == d) return false;
		for(int j =  0; j < 9; ++j)
			if(out[r][j] == d) return false;
		int sr = r/3*3;
		int sc = c/3*3;
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if(out[sr+i][sc+j] == d) return false;
			}
		}
		return true;
	}

	private static void auxSolver2(int r, int c, int[][] in, int[][] out) {
		if (r == 9) {
			for (int[] tmp : out)
				System.out.println(Arrays.toString(tmp));
			System.out.println();
			return;
		}
		if (in[r][c] != 0) {
			out[r][c] = in[r][c];
			auxSolver2(c == 8 ? r + 1 : r, (c + 1) % 9, in, out);
		} else {
			for (int d = 1; d <= 9; ++d) {
				if (isValid2(r, c, d, out)) {
					out[r][c] = d;
					auxSolver2(c == 8 ? r + 1 : r, (c + 1) % 9, in, out);
				}
			}
			out[r][c] = 0;
		}
	}

	public static void main(String[] args) {
		int[][] in = { 
				{ 0, 0, 0, 5, 0, 0, 0, 9, 0 },
				{ 0, 3, 0, 0, 0, 0, 0, 0, 5 }, 
				{ 0, 0, 0, 8, 2, 7, 0, 0, 0 },
				{ 1, 0, 0, 4, 0, 6, 0, 0, 0 }, 
				{ 0, 9, 0, 0, 0, 0, 0, 7, 0 },
				{ 2, 8, 0, 0, 5, 0, 0, 0, 0 }, 
				{ 4, 0, 5, 0, 0, 0, 0, 0, 0 },
				{ 7, 0, 0, 0, 0, 0, 9, 0, 2 }, 
				{ 0, 0, 0, 0, 0, 0, 1, 5, 6 } 
			};
		sudokuSolver2(in);
	}

}

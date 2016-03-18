package com.alg.top20.bt;

import java.util.Arrays;

public class SudokuSolver {

	private static boolean isvalid1(int[][] in) {
		//Fill the logic
		return true;
	}

	private static void aux_sudoku_solver1(int r, int c, int[][] in) {
		if (r == 9) {
			// if (isvalid1(in))
			String tmp = "";
			for (int i = 0; i < in.length; ++i) {
				tmp = tmp + Arrays.toString(in[i]) + " ";
			}
			System.out.println(tmp);
			return;
		}
		if (in[r][c] != 0) {
			aux_sudoku_solver1(c == 8 ? r + 1 : r, (c + 1) % 9, in);
		} else {
			for (int d = 1; d <= 9; ++d) {
				in[r][c] = d;
				aux_sudoku_solver1(c == 8 ? r + 1 : r, (c + 1) % 9, in);
			}
			in[r][c] = 0;
		}
	}

	public static void sudokusolver1(int[][] in) {
		aux_sudoku_solver1(0, 0, in);
	}

	private static boolean isvalid2(int r, int c, int d, int[][] in) {
		for(int j = 0; j < 9; ++j) {
			if(in[r][j] == d || in[j][c] == d) return false;
		}
		int sr = r/3 *3, sc = c/3*3 ;
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if(in[sr+i][sc+j] == d) return false;
			}
		}
		return true;
	}

	private static void aux_sudoku_solver2(int r, int c, int[][] in) {
		if (r == 9) {
			String tmp = "";
			for (int i = 0; i < in.length; ++i) {
				tmp = tmp + Arrays.toString(in[i]) + " ";
			}
			System.out.println(tmp);
			return;
		}
		if (in[r][c] != 0) {
			aux_sudoku_solver2(c == 8 ? r + 1 : r, (c + 1) % 9, in);
		} else {
			for (int d = 1; d <= 9; ++d) {
				if (isvalid2(r, c, d, in)) {
					in[r][c] = d;
					aux_sudoku_solver2(c == 8 ? r + 1 : r, (c + 1) % 9, in);
				}
			}
			in[r][c] = 0;
		}
	}

	public static void sudokusolver2(int[][] in) {
		aux_sudoku_solver2(0, 0, in);
	}

	public static void main(String[] args) {
		int[][] in =  {
				{0,0,3,0,2,0,0,9,0},
				{0,0,2,0,0,5,0,0,0},
				{9,0,4,0,8,0,0,0,1},
				{4,0,0,0,6,0,0,8,0},
				{0,0,0,5,0,7,0,0,0},
				{0,3,0,0,1,0,0,0,4},
				{1,0,0,0,5,0,3,0,9},
				{0,0,0,1,0,0,8,0,0},
				{0,7,0,0,9,0,2,0,0}
		};
		sudokusolver2(in);

	}

}

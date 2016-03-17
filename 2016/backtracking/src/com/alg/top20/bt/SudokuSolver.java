package com.alg.top20.bt;

public class SudokuSolver {

	private static void aux_sudoku_solver1(int r, int c, int[][] in) {
		if (r == 9) {
			if (isvalid(in))
				System.out.println(in);
			return;
		}
		if (in[r][c] != 0) {
			aux_sudoku_solver1(c==8?r+1:r, (c+1)%9, in);
		} else {
			for (int d = 1; d <= 9; ++d) {
				in[r][c] = d;
				aux_sudoku_solver1(c==8?r+1:r, (c+1)%9, in);
			}
			in[r][c] = 0;
		}
	}

	public static void sudokusolver1(int[][] in) {
		aux_sudoku_solver1(0, 0, in);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

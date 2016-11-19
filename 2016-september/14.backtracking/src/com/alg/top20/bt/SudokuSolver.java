package com.alg.top20.bt;

public class SudokuSolver {

	private static boolean isValid(int[][] in) {
		// rows validation

		// columns validation

		// box validation
		return true;
	}

	private static void display(int[][] in) {
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				System.out.print(in[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void sudokuSolver1(int[][] in) {
		for (in[0][0] = 1; in[0][0] <= 9; ++in[0][0]) {
			for (in[0][1] = 1; in[0][1] <= 9; ++in[0][1]) {
				for (in[0][2] = 1; in[0][2] <= 9; ++in[0][2]) {
					for (in[0][3] = 1; in[0][3] <= 9; ++in[0][3]) {
						if (isValid(in)) {
							display(in);
						}
					}
				}
			}
		}
	}

	private static void auxSolver2(int r, int c, int[][] in) {
		if (r == 9) {
			if (isValid(in)) {
				display(in);
				System.out.println();
			}
			return;
		}
		if (in[r][c] != 0) {
			auxSolver2(c == 8 ? r + 1 : r, (c + 1) % 9, in);
		} else {
			for (int d = 1; d <= 9; ++d) {
				in[r][c] = d;
				auxSolver2(c == 8 ? r + 1 : r, (c + 1) % 9, in);
			}
			// initialize the cell back to 0 after all attempts are done
			in[r][c] = 0;
		}
	}

	public static void sudokuSolver2(int[][] in) {
		auxSolver2(0, 0, in);
	}

	private static boolean isDigitValid(int r, int c, int d, int[][] in) {
		//row check 
		for(int j = 0; j < 9; ++j) {
			if(in[r][j] == d) return false;
		}
		
		//column check
		for(int i = 0; i < 9; ++i) {
			if(in[i][c] == d) return false;
		}
		
		//box check
		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if(in[sr+i][sc+j] == d) return false;
			}
		}
		//add heuristics
		return true;
	}

	private static void auxSolver3(int r, int c, int[][] in) {
		if (r == 9) {
			display(in);
			return;
		}
		if (in[r][c] != 0) {
			auxSolver3(c == 8 ? r + 1 : r, (c + 1) % 9, in);
		} else {
			for (int d = 1; d <= 9; ++d) {
				if (isDigitValid(r, c, d, in)) {
					in[r][c] = d;
					auxSolver3(c == 8 ? r + 1 : r, (c + 1) % 9, in);
				}
			}
			// initialize the cell back to 0 after all attempts are done
			in[r][c] = 0;
		}
	}

	public static void sudokuSolver3(int[][] in) {
		auxSolver3(0, 0, in);
	}

	public static void main(String[] args) {
		// int[][] in = new int[9][9];
		// sudokuSolver2(in);

		int[][] in = { { 0, 0, 0, 2, 6, 0, 7, 0, 1 },
				{ 6, 8, 0, 0, 7, 0, 0, 9, 0 }, { 1, 9, 0, 0, 0, 4, 5, 0, 0 },
				{ 8, 2, 0, 1, 0, 0, 0, 4, 0 }, { 0, 0, 4, 6, 0, 2, 9, 0, 0 },
				{ 0, 5, 0, 0, 0, 3, 0, 2, 8 }, { 0, 0, 9, 3, 0, 0, 0, 7, 4 },
				{ 0, 4, 0, 0, 5, 0, 0, 3, 6 }, { 7, 0, 3, 0, 1, 8, 0, 0, 0 } };
		sudokuSolver3(in);
	}

}

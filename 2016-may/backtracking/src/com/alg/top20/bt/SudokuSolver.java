package com.alg.top20.bt;

public class SudokuSolver {

	private static boolean isValid1(int[][] in) {
		for (int r = 0; r < 9; ++r) {
			for (int d = 1; d <= 9; ++d) {
				boolean isfound = false;
				for (int c = 0; c < 9; ++c) {
					if (in[r][c] == d) {
						isfound = true;
						break;
					}
				}
				if (isfound == false)
					return false;
			}
		}

		for (int c = 0; c < 9; ++c) {
			for (int d = 1; d <= 9; ++d) {
				boolean isfound = false;
				for (int r = 0; r < 9; ++r) {
					if (in[r][c] == d) {
						isfound = true;
						break;
					}
				}
				if (isfound == false)
					return false;
			}
		}

		int sr = 0, sc = 0;
		for (int d = 1; d <= 9; ++d) {
			boolean isfound = false;
			for (int i = 0; i < 3; ++i) {
				for (int j = 0; j < 3; ++j) {
					if (in[sr + i][sc + j] == d) {
						isfound = true;
						break;
					}
				}
			}
			if (isfound == false)
				return false;
			sr = (sc == 6) ? (sr + 3) : sr;
			sc = (sc + 3) % 9;
		}

		return true;
	}

	private static void auxSolver1(int r, int c, int[][] in) {
		if (r == 9) {
			if (isValid1(in)) {
				for (int i = 0; i < 9; ++i) {
					for (int j = 0; j < 9; ++j) {
						System.out.print(in[i][j] + " ");
					}
					System.out.println();
				}
			}
			return;
		}
		if (in[r][c] != 0) {
			auxSolver1(c == 8 ? r + 1 : r, (c + 1) % 9, in);
		} else {
			for (int d = 1; d <= 9; ++d) {
				in[r][c] = d;
				auxSolver1(c == 8 ? r + 1 : r, (c + 1) % 9, in);
			}
			in[r][c] = 0;
		}
	}

	public static void solver1(int[][] in) {
		auxSolver1(0, 0, in);
	}

	private static boolean isValid2(int[][] in, int r, int c, int d) {
		for (int j = 0; j < 9; ++j) {
			if (in[r][j] == d) return false;
		}
		for (int i = 0; i < 9; ++i) {
			if (in[i][c] == d) return false;
		}
		int sr = r/3*3, sc = c/3*3;
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (in[sr + i][sc + j] == d) return false;
			}
		}
		//add heuristics
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
	private static void auxSolver2(int r, int c, int[][] in) {
		if (r == 9) {
			display(in);
			return;
		}
		if (in[r][c] != 0) {
			auxSolver2(c == 8 ? r + 1 : r, (c + 1) % 9, in);
		} else {
			for (int d = 1; d <= 9; ++d) {
				if (isValid2(in, r, c, d)) {
					in[r][c] = d;
					auxSolver2(c == 8 ? r + 1 : r, (c + 1) % 9, in);
				}
			}
			in[r][c] = 0;
		}
	}

	public static void solver2(int[][] in) {
		auxSolver2(0, 0, in);
	}

	public static void main(String[] args) {
		int[][] in = { { 0, 0, 3, 0, 2, 0, 0, 9, 0 },
				{ 0, 0, 2, 0, 0, 5, 0, 0, 0 }, { 9, 0, 4, 0, 8, 0, 0, 0, 1 },
				{ 4, 0, 0, 0, 6, 0, 0, 8, 0 }, { 0, 0, 0, 5, 0, 7, 0, 0, 0 },
				{ 0, 3, 0, 0, 1, 0, 0, 0, 4 }, { 1, 0, 0, 0, 5, 0, 3, 0, 9 },
				{ 0, 0, 0, 1, 0, 0, 8, 0, 0 }, { 0, 7, 0, 0, 9, 0, 2, 0, 0 } };
		display(in);
		System.out.println();
		solver2(in);
	}

}

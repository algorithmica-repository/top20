package puzzles;

import java.util.Arrays;

public class SudokuSolver {

	public static void sudokusolver1(int[][] in) {
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

	public static void sudokusolver2(int[][] in) {
		int[][] out = new int[9][9];
		auxSolver2(0, 0, in, out);
	}

	private static boolean isValid2(int r, int c, int d, int[][] out) {
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
		}
	}

	public static void main(String[] args) {
		int[][] in = new int[9][9];
		sudokusolver1(in);
	}

}

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
		for(int d = 1; d <= 9; ++d) {
			in[r][c] = d;
			auxSolver1(c==8?r+1:r, (c+1)%9, in);
		}
	}
	public static void main(String[] args) {
		int[][] in = new int[9][9];
		sudokusolver1(in);
	}

}

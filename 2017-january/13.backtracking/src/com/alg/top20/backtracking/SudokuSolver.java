package com.alg.top20.backtracking;

public class SudokuSolver {
	
	public static void display(int[][] in) {
		for(int i = 0; i < in.length; ++i) {
			for(int j = 0; j < in.length; ++j) {
				System.out.print(in[i][j]+" ");
			}
			System.out.println();				
		}
	}
	private static boolean rowDuplicateCheck(int r, int[][] in) {
		int[] tmp = new int[10];
		for(int j = 0; j < 9;  ++j) {
			int cell = in[r][j];
			if(tmp[cell] != 0) return true;
			else
				tmp[cell] = 1;
		}
		return false;
	}
	
	private static boolean colDuplicateCheck(int c, int[][] in) {
		int[] tmp = new int[10];
		for(int i = 0; i < 9;  ++i) {
			int cell = in[i][c];
			if(tmp[cell] != 0) return true;
			else
				tmp[cell] = 1;
		}
		return false;
	}
	
	private static boolean boxDuplicateCheck(int r, int c, int[][] in) {
		int[] tmp = new int[10];
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				int cell = in[r+i][c+j];
				if(tmp[cell] != 0) return true;
				else
					tmp[cell] = 1;
			}
		}
		return false;
	}
	//validating the 9 by 9 grid 
	private static boolean isValid1(int[][] in) {
		//row checks
		for(int r = 0; r < 9; ++r) 
			if(rowDuplicateCheck(0,in)) return false;
				
		//column checks
		for(int c = 0; c < 9; ++c) 
			if(colDuplicateCheck(c,in)) return false;
		
		//box checks
		for(int r = 0; r < 9; r+=3) {
			for(int c = 0; c < 9; c+=3) {
				if(boxDuplicateCheck(r,c,in)) return false;
			}
		}
		return true;
	}

	private static void auxSolver1(int r, int c, int[][] in) {
		if(r == 9) {
			if(isValid1(in)) {
				display(in);
				return;
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

	//recursive approach
	public static void sudokuSolver1(int[][] in) {
		auxSolver1(0, 0, in);
	}
	
	//branch elimination logic
	private static boolean isValid2(int r, int c, int d, int[][] in) {
		//row check
		for(int j = 0; j < 9; ++j) 
			if(in[r][j] == d) return false;
		//col check
		for(int i = 0; i < 9; ++i) 
			if(in[i][c] == d) return false;
		//box check
		int sr = r/3 * 3;
		int sc = c/3 * 3;
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if(in[sr+i][sc+j] == d) return false;
			}
		}
		return true;
	}
	
	private static void auxSolver2(int r, int c, int[][] in) {
		if(r == 9) {			
			display(in);
			return;
		}

		if (in[r][c] != 0) {
			auxSolver2(c == 8 ? r + 1 : r, (c + 1) % 9, in);
		} else {
			for (int d = 1; d <= 9; ++d) {
				if(isValid2(r,c,d,in)) {
					in[r][c] = d;
					auxSolver2(c == 8 ? r + 1 : r, (c + 1) % 9, in);
				}
			}
			in[r][c] = 0;
		}
	}

	//backtracking approach
	public static void sudokuSolver2(int[][] in) {
		auxSolver2(0, 0, in);
	}

	public static void main(String[] args) {
		int[][] in = 
		{
				{0,0,9,0,0,0,0,0,6},
				{0,0,0,0,3,7,0,0,4},
				{4,7,0,9,0,0,2,0,0},
				{0,0,0,5,0,6,0,7,0},
				{1,0,0,0,8,0,0,0,3},
				{0,4,0,2,0,3,0,0,0},
				{0,0,8,0,0,9,0,1,5},
				{5,0,0,6,2,0,0,0,0},
				{6,0,0,0,0,0,8,0,0}
		};
		//int[][] in = new int[9][9];
		sudokuSolver2(in);

	}

}

package com.alg.top20.basic;

class Pair {
	int x;
	int y;
	Pair(int r, int c) {
		x = r;
		y = c;
	}
	public void display() {
		System.out.println(x + " " + y);
	}
}
public class GridSearch {

	
	public static Pair search(int[][] in, int x) {
		int r = 0, c = in.length - 1;
		while(r < in.length && c >= 0) {
			if(in[r][c] == x)
				return new Pair(r,c);
			else if(x < in[r][c])
					--c;
			else	++r;
		}
		return new Pair(-1,-1);
	}
	
	public static void main(String[] args) {
		int[][] a = {
				{10,20,30 },
				{11,21,31 },
				{12,22,32 }
		};
		search(a, 22).display();
	}
}

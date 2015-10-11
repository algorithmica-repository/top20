package com.alg.rec;

public class BinarySequence {
	
	//we cant use n in static code writing
	public static void binary1(int n) {
		for(int i = 0; i <= 1; ++i) {
			for(int j = 0; j <= 1; ++j) {
				for(int k = 0; k <= 1; ++k) {
					System.out.println(i + "" + j + "" + k);
				}
			}
		}
	}
	
	private static void auxBinary2(int d, int n, int[] out) {
		if(d == n) { 
			for(int x:out) 
				System.out.print(x);
			System.out.println();
			return;
		}
		for(int i = 0; i <= 1; ++i) {
			out[d] = i;
			auxBinary2(d+1, n, out);
		}
	}
	
	public static void binary2(int n) {
		int[] out = new int[n];
		auxBinary2(0, 3, out);
	}	
	
	public static void main(String[] args) {		
		binary1(3);
		binary1(4);
		binary2(3);
		binary2(4);
	}

}

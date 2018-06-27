package com.alg.top20.cs;
import java.util.Arrays;


public class TernarySeq {

	public static void ternary1(int n){
		for(int i = 0; i <= 2; ++i) {
			for(int j = 0; j <= 2; ++j) {
				for(int k = 0; k <= 2; ++k) {
					System.out.println(i+" "+j+" " +k);
				}
			}
		}
	}
	
	public static void ternary2(int n){
		int[] out = new int[n];
		auxTernary(0, n, out);		
	}
	private static void auxTernary(int d, int n, int[] out) {
		if(d == n) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i <= 2; ++i) {
			out[d] = i;
			auxTernary(d+1, n, out);
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ternary2(n);
	}

}

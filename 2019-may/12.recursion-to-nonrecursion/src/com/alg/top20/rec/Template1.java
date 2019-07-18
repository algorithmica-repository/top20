package com.alg.top20.rec;

public class Template1 {

	public static int f_rec(int n) {
		if(n == 0) return 0;
		return n + f_rec(n-1);
	}
	
	public static int f_nonrec(int n) {
		int sum = 0;
		while(n > 0) {
			sum = sum + n--;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(f_nonrec(n));
	}
}

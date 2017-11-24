package com.alg.top20.combinatorial;

public class ExprEval1 {

	public static int exprEvaluation1(int[] in, int s) {
		MyInteger count = new MyInteger(0);
		auxEvaluation1(0, in, s, count);
		return count.get();
	}
	private static void auxEvaluation1(int d, int[] in, int s, MyInteger count) {
		if(d == in.length) {
			if(s == 0) count.incr(1);
			return;
		}
		auxEvaluation1(d+1, in, s-in[d], count);
		auxEvaluation1(d+1, in, s+in[d], count);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

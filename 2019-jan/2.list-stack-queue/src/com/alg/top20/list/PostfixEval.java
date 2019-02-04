package com.alg.top20.list;

import java.util.Stack;

public class PostfixEval {

	//TC:O(n)  SC:O(n)
	public static int evalPostfix(String[] in) {
		Stack<Integer> st = new Stack<Integer>();
		for (String x : in) {
			if (x.equals("+") || x.equals("-") || x.equals("*")
					|| x.equals("/")) {
				int second = st.pop();
				int first = st.pop();
				if (x.equals("+"))
					st.push(first + second);
				else if (x.equals("-"))
					st.push(first - second);
				else if (x.equals("*"))
					st.push(first * second);
				else
					st.push(first / second);
			} else
				st.push(Integer.parseInt(x));
		}
		return st.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

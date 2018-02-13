package com.alg.top20.ds.stack;

import java.util.Stack;

public class Calculator {
	
	public int calculate1(String s) {
		String[] tokens = s.split("()");
		int sign = 1;
		int res = 0;
		Stack<Integer> st = new Stack<Integer>();
		for(String token: tokens) {
			token = token.trim();
			if(token.equals("+"))
				sign = 1;
			else if(token.equals("-"))
				sign = -1;
			else if(token.equals("(")) {
				st.push(res);
				st.push(sign);
				res = 0;
				sign = 1;
			} else if(token.equals(")")) {
				res = st.pop() * res + st.pop();
			} else {
				res += sign*Integer.parseInt(token);
			}
		}
		return res;
    }
}

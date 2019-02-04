package com.alg.top20.list;

import java.util.Stack;

public class BackSpace {

	//TC:O(n)    SC:O(n)
	public static String getResult(String in) {
		Stack<Character> st = new Stack<Character>();
		for(int i = 0; i < in.length(); ++i) {
			if(in.charAt(i) != '<')
				st.push(in.charAt(i));
			else
				st.pop();
		}
		StringBuffer res = new StringBuffer();
		while(! st.empty())
			res.append(st.pop());
		return res.reverse().toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
